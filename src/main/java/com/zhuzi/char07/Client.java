package com.zhuzi.char07;

/**
 * @Title: Clent.java
 * @Package com.zhuzi.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午3:00:55
 *
 */ 

public class Client {
	public static void main(String[] args) {
		Thing thing = new Thing();
		thing.setValue("张珊");

		Thing cloneThing = thing.clone();
		cloneThing.setValue("李四");

		System.out.println(thing.getValue());
		// [张珊, 李四]
	}
}
