package com.zhuziym.char09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: Client125.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午4:38:20
 *
 */
public class Client125 {
	public static void main(String[] args) {
		// 2个线程的线程池
		ExecutorService ex = Executors.newFixedThreadPool(2);
		// 多次执行线程体
		for (int i = 0; i < 6; i++) {
			ex.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		// 关闭执行器
		ex.shutdown();
	}
}
