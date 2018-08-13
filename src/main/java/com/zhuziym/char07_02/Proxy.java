package com.zhuziym.char07_02;

/**
 * @Title: Proxy.java
 * @Package com.zhuziym.char07_02
 * @Description: TODO(代理主题角色)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 上午11:29:31
 *
 */
public class Proxy implements Subject {

	// 要代理哪个实现类
	private Subject sub = null;

	public Proxy(Subject sub) {
		this.sub = sub;
	}

	@Override
	public void request() {
		this.before();
		sub.request();
		this.after();
	}

	/**
	 * 预处理
	 */
	public void before() {
		System.out.println("Proxy.before()");
	}

	/**
	 * 善后处理
	 */
	public void after() {
		System.out.println("Proxy.after()");
	}
}
