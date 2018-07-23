package com.zhuziym.char04;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 下午4:04:03
 *
 */
public class Client53 {
	public static void main(String[] args) {
		String string = "好是好啊";
		System.out.println(string.replace("是", ""));//好好啊
		
		String string2 = "$是$好$";
		//参数要求是正则
		System.out.println(string2.replaceAll("$", ""));//$是$好$
	}
}
