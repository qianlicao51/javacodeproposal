package com.zhuzi.char01;

/**
 * @Title: Singleto.java
 * @Package com.zhuzi.char01
 * @Description: TODO(懒汉单例模式——线程不安全)
 * @author 作者 grq
 * @version 创建时间：2018年8月3日 下午3:53:41
 *
 */
public class Singleto {
	private static Singleto singleto = null;

	// 限制产生多个对象
	private Singleto() {
	}

	public static Singleto getSingleto() {
		 
		if (singleto == null) {
			return new Singleto();
		}
		return singleto;
	}
}
