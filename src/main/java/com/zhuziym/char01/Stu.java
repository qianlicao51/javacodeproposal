package com.zhuziym.char01;

import java.io.Serializable;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午9:59:57
 *
 */
public class Stu implements Serializable{
	private static final long serialVersionUID = 1L;
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stu(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Stu [name=" + name + "]";
	}

}
