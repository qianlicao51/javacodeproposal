package com.zhuzi.char02;

import java.lang.reflect.Constructor;

import com.zhuzi.char01.Singleton;

/**
 * @Title: SingleFactory.java
 * @Package com.zhuzi.char01
 * @Description: TODO(工厂单例模式)
 * @author 作者 grq
 * @version 创建时间：2018年8月4日 下午4:43:43
 *
 */
public class SingleFactory {
	private static Singleton singleton;
	static {
		try {
			Class cl = Class.forName(Singleton.class.getName());
			// 获得无参构造函数
			Constructor constructor = cl.getDeclaredConstructor();
			// 设置无参构造函数为可访问
			constructor.setAccessible(true);
			singleton = (Singleton) constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Singleton getSingleton() {
		return singleton;
	}
}
