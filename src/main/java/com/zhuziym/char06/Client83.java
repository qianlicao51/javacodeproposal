package com.zhuziym.char06;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午8:12:50
 *
 */
public class Client83 {
	public static void main(String[] args) {
		for (Season season : Season.values()) {
			System.out.println(season);
		}

	}
}

enum Season {
	Spring, Summer, Autumn, Winter;
	// 是否包含指定名称的枚举项
	public static boolean contains(String name) {
		// 所有的枚举值
		Season[] values = values();
		for (Season season : values) {
			if (season.name().equals(name)) {
				return true;

			}

		}
		return false;
	}
}