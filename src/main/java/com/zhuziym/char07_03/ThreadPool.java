package com.zhuziym.char07_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: ThreadPool.java
 * @Package com.zhuziym.char07_03
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午6:33:06
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println("ThreadPool.main(...).new Runnable() {...}.run()");

				}
			});
			threadPool.shutdown();
		}

	}
}
