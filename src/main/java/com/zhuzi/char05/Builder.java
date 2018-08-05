package com.zhuzi.char05;
/**
 * @Title:  Builder.java   
 * @Package com.zhuzi.char05   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午12:24:20
 *
 */
public abstract class Builder{
	//设置产品的不同部分，以获得不同的产品
	public abstract void setPart();
	//建造产品 
	public abstract Product builderProduct();
}
