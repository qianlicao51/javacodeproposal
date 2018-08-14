package com.zhuziym.char08;

/**
 * @Title: Invoker.java
 * @Package com.zhuziym.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 上午10:25:46
 *
 */
public class Invoker {
	public static void m1() {
		System.out.println(Foo.m());
	}

	public static void m2() {
		System.out.println(Foo.m());
	}

	public static void main(String[] args) {
		m1();
		m2();
	}
}