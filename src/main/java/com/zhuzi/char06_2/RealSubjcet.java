package com.zhuzi.char06_2;

/**
 * @Title: RealSubjcet.java
 * @Package com.zhuzi.char06_2
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午1:26:47
 *
 */
public class RealSubjcet implements Subject {

	@Override
	public void doSomething(String str) {
		System.out.println("--------->" + str);
	}

}
