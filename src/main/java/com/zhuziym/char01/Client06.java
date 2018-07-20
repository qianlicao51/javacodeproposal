package com.zhuziym.char01;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午6:35:52
 *
 */
public class Client06 {
	public static void main(String[] args) {
		//向上转型
		Base base = new Sub();
		base.fun(100, 50);
		
		//不转型
		Sub sub = new Sub();
		/*
		 * 此处报错
		 * 
		 * */
		//sub.fun(100, 50);
	}
}

class Base {
	void fun(int price, int... discounts) {
		System.out.println("Base.fun()");
	}
}
class Sub extends Base {
	@Override
	void fun(int price, int[] discounts) {
		System.out.println("Sub.fun()");
	}
}