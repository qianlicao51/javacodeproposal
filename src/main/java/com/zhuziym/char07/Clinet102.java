package com.zhuziym.char07;

import java.lang.reflect.Method;

/**
 * @Title: Clinet102.java
 * @Package com.zhuziym.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月9日 下午4:04:17
 *
 */
public class Clinet102 {
public static void main(String[] args) throws Exception {

	// 方法名称
	String methodName = "doStuff";
	// TODO 获取自身类的所有方法，包括 public 私有 而写不受限于访问权限
	Method declaredMethod = Foo.class.getDeclaredMethod(methodName);
	// TODO getMethod 获得的是publc 访问级别 的方法(包括从父类继承过来的方法)
	Method method = Foo.class.getMethod(methodName);
}

	// 静态内部类
	static class Foo {
		void doStuff() {
		}

	}
}
