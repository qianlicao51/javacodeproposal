package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午5:04:14
 *
 */
public class Client74 {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("上海");
	list.add("广州");
	list.add("广州");
	list.add("北京");
	list.add("天津");
	System.out.println(list);
	System.out.println(list.indexOf("广州"));
	// 二分法查找
	System.out.println(Collections.binarySearch(list, "广州"));

	/*
	 * [上海, 广州, 广州, 北京, 天津] 1 2
	 */
}
}
