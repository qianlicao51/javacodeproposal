package com.zhuziym.char07;

import java.lang.reflect.Method;

/**
 * @Title: Client1021.java
 * @Package com.zhuziym.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月9日 下午4:21:44
 *
 */
public class Client1021 {
public static void main(String[] args) {

	Method[] methods = Dog.class.getMethods();
	Method[] declaredMethods = Dog.class.getDeclaredMethods();

	// 反射到父类 再次获取通过继承得到的父类上的方法
	Class<? super Dog> superclass = Dog.class.getSuperclass();
	System.out.println(superclass.getName());
	for (Method method : methods) {
		System.out.println(method.getName());
	}
}
}
