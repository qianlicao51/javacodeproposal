package com.zhuziym.char07;

/**
 * @Title: Aminal.java
 * @Package com.zhuziym.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月9日 下午4:22:16
 *
 */
public class Aminal {

	String name;

	public void pubMeth() {

		System.out.println(this.name + "Aminal.pubMeth()");
	}

	void friMeth() {

		System.out.println(this.name + "Aminal.friMeth()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
