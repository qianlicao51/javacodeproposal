package com.zhuzi.char06_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title: MyInvocationHandler.java
 * @Package com.zhuzi.char06_2
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午1:29:40
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	// 被代理的对象
	private Object target = null;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//执行被代理的方法
		return method.invoke(this.target, args);
	}

}
