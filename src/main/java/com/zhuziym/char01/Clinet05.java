package com.zhuziym.char01;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午6:27:10 别让null值和空值威胁到变长方法
 */
public class Clinet05 {
	public void method(String str, Integer... integers) {
	}

	public void method(String str, String... strs) {
	}

	public static void main(String[] args) {
		Clinet05 clinet = new Clinet05();
		String[] strs = null;
		clinet.method("GRQ", strs);
	}

}
