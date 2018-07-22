package com.zhuziym.char02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月22日 下午6:35:55 提防包装类型null值
 */
public class Clinet26 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		calcSum(list);

	}

	public static int calcSum(List<Integer> list) {
		int count = 0;
		for (Integer integer : list) {
			count += integer;
		}
		return count;
	}
}
