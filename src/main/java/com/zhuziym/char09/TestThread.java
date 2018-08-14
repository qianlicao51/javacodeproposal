package com.zhuziym.char09;

/**
 * @Title: TestThread.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 上午11:10:09
 *
 */
public class TestThread implements Runnable {
	// 启动线程
	public void start(int priority) {
		Thread thread = new Thread(this);
		thread.setPriority(priority);
		thread.start();
	}

	@Override
	public void run() {
		// 消耗CPU计算
		for (int i = 0; i < 100000; i++) {
			Math.hypot(Math.pow(924526789, i), Math.cos(i));
		}
		// 输出线程优先级
		System.out.println("getPriority>" + Thread.currentThread().getPriority());
	}

}
