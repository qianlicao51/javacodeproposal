package com.zhuziym.char07_03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.zhuziym.char07_02.Subject;

/**
 * @Title: SubjectHandler.java
 * @Package com.zhuziym.char07_03
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 上午11:37:10
 *
 */
public class SubjectHandler implements InvocationHandler {
	private Subject sub;

	public SubjectHandler(Subject sub) {
		super();
		this.sub = sub;
	}

	// 委托处理方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("SubjectHandler.invoke()--预处理");
		// 直接调用被代理类的方法
		Object object = method.invoke(sub, args);
		System.out.println("SubjectHandler.invoke()--后处理");
		return object;
	}

}
