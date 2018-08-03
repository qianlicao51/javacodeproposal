package com.zhuzi.char01;

/**
 * @author 作者 grq
 * @version 创建时间：2018年8月2日 下午11:49:00 单例
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();

	// 限制产生多个
	private Singleton() {

	}

	public static Singleton getSingleton() {
		return singleton;
	}

	public static void doSomething() {
	}
}
