package com.zhuziym.char07;

import java.lang.reflect.Method;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

/**
 * @Title: Client103.java
 * @Package com.zhuziym.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月9日 下午6:45:12
 *
 */
public class Client103 {
	public static void main(String[] args) throws Exception, SecurityException {

		// 反射获得方法
		Method method = Foo.class.getMethod("doStuff");
		// 打印方法可访问性
		System.out.println(method.isAccessible());
		method.setAccessible(true);
		method.invoke(new Foo());
		/*
		 * 结果 false Client103.Foo.doStuf()
		 */

	}

}
