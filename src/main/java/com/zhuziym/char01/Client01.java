package com.zhuziym.char01;

import java.util.Random;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月20日 下午5:29:13 莫让常量蜕变成变量
 */
public class Client01 {
	public static void main(String[] args) {
		// TODO 下面这2个打印出来时相同的，我本以为是不同的。
		// TODO 但是多次运行，每次运行的结果是不一样的
		System.out.println("变化的常量" + Const.RAND_CONST);
		System.out.println("变化的常量" + Const.RAND_CONST);
	}
}

interface Const {
	// 变化的常量
	public static final int RAND_CONST = new Random().nextInt();
}