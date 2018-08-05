package com.zhuzi.char05;
/**
 * @Title:  Director.java   
 * @Package com.zhuzi.char05   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午12:28:50
 *
 */
public class Director {

	private Builder builder = new ConcreteProcuct();
	
	//建造不同的产品
	public Product getProduct(){
		
		return builder.builderProduct();
	}
}
