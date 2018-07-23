package com.zhuziym.char05;

import java.util.Arrays;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 下午5:06:32
 *
 */
public class Clinet65 {
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5 };
		List<int[]> asList = Arrays.asList(data);
		System.out.println("列表中元素个数" + asList.size());
		// 列表中元素个数1
		Integer[] datas = { 1, 2, 3, 4, 5 };
		List<Integer> asLists = Arrays.asList(datas);
		System.out.println("列表中元素个数" + asLists.size());
		// 列表中元素个数5
	}
}
