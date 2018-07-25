package com.zhuziym.char06;

import java.util.Arrays;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午9:14:27
 *
 */
public class Client87 {
	public static void main(String[] args) {
		List<String> asList = Arrays.asList("Spring", "summer");

		for (String name : asList) {
			// 查找字面值与ame相同的枚举项

			Season season = Season.valueOf(name);
			if (season != null) {
				System.out.println(season);
			} else {
				System.out.println("没有相关枚举项");
			}
		}
	}
}
/*
 * Spring Exception in thread "main" java.lang.IllegalArgumentException: No enum
 * constant com.zhuziym.char06.Season.summer at
 * java.lang.Enum.valueOf(Enum.java:238) at
 * com.zhuziym.char06.Season.valueOf(Client83.java:1) at
 * com.zhuziym.char06.Client87.main(Client87.java:18)
 */
