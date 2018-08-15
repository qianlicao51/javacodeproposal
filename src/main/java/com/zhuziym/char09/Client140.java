package com.zhuziym.char09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.primitives.Ints;

/**
 * @Title: Client140.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 下午4:03:21
 *
 */
public class Client140 {
	public static void main(String[] args) {
		// 不可变集合
		ImmutableList<String> list = ImmutableList.of("A", "B", "C");

		// 不可变Map
		ImmutableMap<Integer, String> map = ImmutableMap.of(1, "A", 2, "B", 3, "C");

		// 多值Map
		ArrayListMultimap<Object, Object> arrayListMultimap = ArrayListMultimap.create();

		arrayListMultimap.put("name", "grq");
		arrayListMultimap.put("name", "lifeng");
		System.out.println(arrayListMultimap);

		// table
		Table<Double, Double, String> g = HashBasedTable.create();

		g.put(31.23, 121.38, "人民广场");
		System.out.println(g);

		// 类似于数据库表的存储方式
		Table<Integer, Integer, String> user = HashBasedTable.create();
		user.put(1, 1, "grq");
		user.put(1, 2, "sunjie");
		String string = user.get(1, 2);
		System.out.println(string);

		// Map操作
		HashMap<String, Integer> useMap = new HashMap();
		useMap.put("grq", 25);
		useMap.put("sunjie", 24);
		useMap.put("dou", 22);

		// 所有年龄大于22的人
		Predicate valuePredicate;
		Map<String, Integer> filterValues = Maps.filterValues(useMap, new Predicate<Integer>() {

			@Override
			public boolean apply(Integer input) {
				return input > 22;
			}
		});

		System.out.println(filterValues);

		// 基本类型工具
		/**
		 * 基本类型工具是以基本类型+s的方式命名的，只是针对基本类型 ，不是针对包装类型
		 */

		int[] insts = { 1, 23, 5, 5, 88, 21, 43 };
		// 最大值
		System.out.println(Ints.max(insts));
	}
}
