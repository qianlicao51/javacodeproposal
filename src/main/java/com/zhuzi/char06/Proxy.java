package com.zhuzi.char06;

/**
 * @Title: Proxy.java
 * @Package com.zhuzi.char06
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午1:08:55
 *
 */
public class Proxy implements Subject {
	// 要代理的那个类
	private Subject subject = null;

	// 默认被代理
	public Proxy() {
		this.subject = new Proxy();
	}

	// 通过构造函数传递代理类
	public Proxy(Object obj) {
	}

	
	@Override
	public void request() {
		this.before();
		this.subject.request();
		this.after();
	}

	public void after() {
		System.out.println("善后处理");
	}

	public void before() {
		System.out.println("预处理");
	}
}
