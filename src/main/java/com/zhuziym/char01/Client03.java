package com.zhuziym.char01;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午6:17:46
 *
 */
public class Client03 {
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i < 100 ? 90 : 100);
		String s1 = String.valueOf(i < 100 ? 90 : 100.0);
		System.out.println("两者是否相等" + s.equals(s1));
		System.out.println(s + "<>" + s1);
		// 两者是否相等false
		// 90<>90.0
	}
}
