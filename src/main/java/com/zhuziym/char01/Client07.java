package com.zhuziym.char01;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午8:10:49 建议7 警惕自增的陷阱
 */
public class Client07 {
	public static void main(String[] args) {
		int count = 0;

		for (int i = 0; i < 10; i++) {
			count = count++;
		}
		System.out.println("count =" + count);
	}
}
