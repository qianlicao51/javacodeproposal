package com.zhuziym.char09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Title: Client124.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午3:36:17
 *
 */
public class Client124 {
	public static void main(String[] args) throws Exception {
		// 生成一个线程的异步执行器
		ExecutorService es = Executors.newSingleThreadExecutor();
		// 线程执行后的期望值
		Future<Integer> future = es.submit(new TaxCalculator(100));

		while (!future.isDone()) {
			// 还没完成等待200毫秒
			TimeUnit.MILLISECONDS.sleep(200);
			// 输出进度条
			System.out.print("#");
		}
		System.out.println("\n计算完成，结果是" + future.get());
		es.shutdown();

	}
}
