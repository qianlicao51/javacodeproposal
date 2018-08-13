package com.zhuziym.char07_03;

import com.zhuziym.char07_02.Subject;

/**
 * @Title: Client106.java
 * @Package com.zhuziym.char07_03
 * @Description: TODO(动态代理)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午2:38:45
 *
 */
public class Client106 {
	public static void main(String[] args) {

		// 具体主题角色，也就是被代理类
		Subject subject = new RealSubject();

		// 代理实例的处理 handler
		SubjectHandler handler = new SubjectHandler(subject);

		// 当前加载器
		ClassLoader classLoader = subject.getClass().getClassLoader();

		// 动态代理
		Subject proxyInstance = (Subject) java.lang.reflect.Proxy.newProxyInstance(classLoader, subject.getClass().getInterfaces(), handler);

		// 执行具体主题角色的方法
		proxyInstance.request();

	}
}
