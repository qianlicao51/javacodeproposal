package com.zhuzi.char06_2;

/**
 * @Title: BeforeAdvice.java
 * @Package com.zhuzi.char06_2
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午1:36:57
 *
 */
public class BeforeAdvice implements IAdvice {

	@Override
	public void exex() {
		System.out.println("BeforeAdvice.exex()");
	}

}
