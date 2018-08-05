package com.zhuzi.char05;
/**
 * @Title:  ConcreteProcuct.java   
 * @Package com.zhuzi.char05   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午12:26:55
 *
 */
public class ConcreteProcuct extends Builder {
private Product product = new Product();
	@Override
	public void setPart() {
		// 设置产品零件
		
	}

	@Override
	public Product builderProduct() {
		// 组建一个产品
		return product;
	}

}
