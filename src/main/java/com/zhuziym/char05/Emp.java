package com.zhuziym.char05;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午4:22:40
 *
 */
public class Emp implements Comparable<Emp> {
	// 根据id 排序
	private int id;
	private String name;
	private Postion postion;


	@Override
	public int compareTo(Emp o) {
		// 正序
		// return new CompareToBuilder().append(id, o.id).toComparison();
		return new CompareToBuilder().append(postion, o.postion)// 职位排序
				.append(id, o.id)// 工号排序
				.toComparison();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	/////////////
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Postion getPostion() {
		return postion;
	}

	public void setPostion(Postion postion) {
		this.postion = postion;
	}

	public Emp(int id, String name, Postion postion) {
		super();
		this.id = id;
		this.name = name;
		this.postion = postion;
	}
}
