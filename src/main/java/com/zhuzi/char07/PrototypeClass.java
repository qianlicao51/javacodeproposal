package com.zhuzi.char07;
 
/**
 * @Title: PrototypeClass.java
 * @Package com.zhuzi
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午2:38:50
 *
 */
public class PrototypeClass implements Cloneable {

	@Override
	protected PrototypeClass clone()  {
		PrototypeClass prototypeClass= null;
		try {
			 prototypeClass=(PrototypeClass) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototypeClass;
	}
}
