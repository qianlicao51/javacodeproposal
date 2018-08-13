package com.zhuziym.char07_04;

/**
 * @Title: Client107.java
 * @Package com.zhuziym.char07_04
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午7:15:25
 *
 */
public class Client107 {
	public static void main(String[] args) {

		// 定义Jetty这只老鼠
		Animal jetty = new Rat();

		// 为Jetty增加飞行能力
		jetty = new DecorateAnimal(jetty, FlyFeature.class);

		// 为Jetty增加挖掘能力
		jetty = new DecorateAnimal(jetty, DigFeature.class);

		//
		jetty.soStuff();
	}
}
