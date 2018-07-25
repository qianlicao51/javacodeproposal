package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午6:09:18
 *
 */
public class Cient76 {
	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		aList.add("C");
		aList.add("V");
		List<String> bList = new ArrayList<String>();

		bList.add("B");
		bList.add("C");
		bList.add("BB");

		// 并集：也叫做合计，把两个集合加起来
		// aList.addAll(bList);

		// 交集：计算两个集合共有的元素
		// aList.retainAll(bList);

		// 差集：由所有属于A但是不属于B的元素组成的集合(从A中删除B)
		// aList.removeAll(bList);

		// 无重复的并集(1:删除B在A出现的元素；2:把剩余的B元素加到A)
		bList.removeAll(aList);
		aList.addAll(bList);
		System.out.println(aList);

	}
}
