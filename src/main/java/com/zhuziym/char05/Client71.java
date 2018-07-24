package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月24日 上午10:13:16
 *
 */
public class Client71 {

	public static void main(String[] args) {

		// 删除数组 20·30 元素
		// 初始化一个固定长度，不可变列表
		List<String> listData = Collections.nCopies(100000, "grq");
		//变为可变数组
		List<String> list = new ArrayList<String>(listData);
		long start = System.currentTimeMillis();
		for (int i = 20; i < 30; i++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
 
		List<String> list2 = new ArrayList<String>(listData);
		start = System.currentTimeMillis();
		list2.subList(20, 30).clear();
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
