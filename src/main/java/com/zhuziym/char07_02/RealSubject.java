package com.zhuziym.char07_02;
/**
 * @Title:  RealSubject.java   
 * @Package com.zhuziym.char07_02   
 * @Description:    TODO(具体主题角色)   
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 上午11:28:52
 *RealSubjcet
 */
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("RealSubject.request()");
	}

}
