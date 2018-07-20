package com.zhuziym.char02;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午10:49:37
 *用偶判断，不用奇判断
 */
public class Client21 {
	public static void main(String[] args) {
		System.out.println(remainder(5, 2));// 1
		System.out.println(remainder(4, 2));// 0
		System.out.println(remainder(-1, 2));// -1
	}

	//模拟取余计算，
	static int remainder(int dividend, int divisor) {
		return dividend - dividend / divisor * divisor;
	}
}
