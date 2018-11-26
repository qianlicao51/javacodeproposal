package com.zhuzijava8.char03;

import java.io.File;
import java.io.FileFilter;

/**
 * @Title: Demo1.java
 * @Package com.zhuzijava8.char03
 * @Description: TODO(lamdba表达式)
 * @author 作者 grq
 * @version 创建时间：2018年11月26日 下午1:49:08
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		lamFileDemo();
		lamdbaThreadDemo();
	}

	/**
	 * lamdba线程
	 */
	private static void lamdbaThreadDemo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello word");
			}
		});

		// lamdba表达式
		new Thread(()->System.out.println("hello word"));

	}

	private static void lamFileDemo() {
		File targetFile = new File(".");
		System.out.println(targetFile.getAbsolutePath());
		File[] listFiles = targetFile.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isHidden();
			}
		});
		for (File file : listFiles) {
			System.out.println("传统方法获取> " + file.getName());
		}
		// lamdba表达式
		File[] listFiles2 = targetFile.listFiles(t -> t.isHidden());
		for (File file : listFiles2) {
			System.out.println("lamdba表达式> " + file.getName());
		}
		// 书上lamdba方法
		File[] listFiles3 = targetFile.listFiles(File::isHidden);
		for (File file : listFiles3) {
			System.out.println("lamdba表达式> " + file.getName());
		}
	}
}
