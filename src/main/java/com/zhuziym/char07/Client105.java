package com.zhuziym.char07;

import java.lang.reflect.Array;

/**
 * @Title: Client105.java
 * @Package com.zhuziym.char07
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月9日 下午7:25:12
 *
 */
public class Client105 {
	public static void main(String[] args) {
		// 动态创建数组
		String[] strs = (String[]) Array.newInstance(String.class, 8);
		// 创建一个多维数组
		int[][] ints = (int[][]) Array.newInstance(int.class, 2, 3);
	}
}
