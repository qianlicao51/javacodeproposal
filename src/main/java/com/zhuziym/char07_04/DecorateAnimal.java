package com.zhuziym.char07_04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @Title: DecorateAnimal.java
 * @Package com.zhuziym.char07_04
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午7:05:18
 *
 */
public class DecorateAnimal implements Animal {

	// 被包装的动物
	private Animal animal;

	// 使用哪一个包装器
	private Class<? extends Feature> clz;

	public DecorateAnimal(Animal animal, Class<? extends Feature> clz) {
		this.animal = animal;
		this.clz = clz;
	}

	@Override
	public void soStuff() {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object obj = null;
				// 设置包装条件
				if (Modifier.isPublic(method.getModifiers())) {
					obj = method.invoke(clz.newInstance(), args);
				}
				animal.soStuff();
				return obj;
			}
		};

		// 当前加载器
		ClassLoader cl = getClass().getClassLoader();
		Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
		proxy.load();
	}
}
