package com.zhuziym.char02;

import java.util.Scanner;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月22日 下午6:05:44
 * 边界
 */
public class Client24 {

	// 一个会员拥有产品最多数量
	public final static int LIMIT = 2000;

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);// 2147483647
		int cur = 1000;
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入需要预定的数量");
		while (scanner.hasNextInt()) {
			int order = scanner.nextInt();
			// 当前拥有的与预定产品的数量和
			if (order > 0 && order + cur <= LIMIT) {
				System.out.println("预定产品个数为:" + order);
			} else {
				System.out.println("超过最大限额，预定失败");
			}
		}

	}
}
