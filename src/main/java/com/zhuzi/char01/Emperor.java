package com.zhuzi.char01;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Title: Emperor.java
 * @Package com.zhuzi.char01
 * @Description: TODO(单例允许存在2个对象)
 * @author 作者 grq
 * @version 创建时间：2018年8月3日 下午4:44:05
 *
 */

public class Emperor {
	// 定义最多能产生的实例数量
	private static int maxNumOfEmperor = 2;
	// 每个皇帝的名字
	private static ArrayList<String> nameList = new ArrayList<String>();
	// 容纳皇帝的实例
	private static ArrayList<Emperor> emperorList = new ArrayList<Emperor>();
	// 当前皇帝的序号
	private static int countNumOfEmperor = 0;

	// 产出所有对象
	static {
		for (int i = 0; i < maxNumOfEmperor; i++) {
			emperorList.add(new Emperor("皇帝" + (i + 1)));
		}
	}

	public static Emperor getInstance() {
		// 随机
		countNumOfEmperor = new Random().nextInt(maxNumOfEmperor);
		return emperorList.get(countNumOfEmperor);
	}

	private Emperor() {

	}

	// 传入名称，建立一个对象
	private Emperor(String name) {
		nameList.add(name);
	}

	public static void say() {
		System.out.println(nameList.get(countNumOfEmperor));
	}
	public static void main(String[] args) {
		int minSnum=5;
		for (int i = 0; i <minSnum; i++) {
			Emperor instance = Emperor.getInstance();
			System.out.print("第"+(i+1)+"个大臣 拜见的是");
			instance.say();
		}
		/*
		 * 第1个大臣 拜见的是皇帝1 
		 * 第2个大臣 拜见的是皇帝1 
		 * 第3个大臣 拜见的是皇帝2 
		 * 第4个大臣 拜见的是皇帝1 
		 * 第5个大臣 拜见的是皇帝2
		 */

	}
}
