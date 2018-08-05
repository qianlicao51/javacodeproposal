package com.zhuzi.char07;

import java.util.ArrayList;

/**
 * @Title: Thing.java
 * @Package com.zhuzi.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午2:56:43
 *
 */
public class Thing implements Cloneable {
	// 定义私有变量
	private ArrayList<String> arrayList = new ArrayList<String>(16);

	@Override
	protected Thing clone() {
		Thing thing = null;
		try {
			thing = (Thing) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return thing;
	}

	// 设置hashMap值
	public void setValue(String val) {
		this.arrayList.add(val);
	}

	public ArrayList<String> getValue() {
		return this.arrayList;
	}
	
}
