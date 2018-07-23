package com.zhuziym.char05;

import java.util.Arrays;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 下午4:46:19
 *
 */
public class Client61 {

	public static void main(String[] args) {

	}

	public static <T> T[] expandCapactiy(T[] datas, int newLen) {
		// 不能是负值
		newLen = newLen < 0 ? 0 : newLen;
		// 生成一个新数组，并拷贝原值
		return Arrays.copyOf(datas, newLen);

	}
}
