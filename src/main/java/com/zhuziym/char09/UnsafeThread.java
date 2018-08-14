package com.zhuziym.char09;

/**
 * @Title: UnsafeThread.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午3:13:31
 *
 */
public class UnsafeThread implements Runnable {
	// 共享资源
	private volatile int count = 0;
	@Override
	public void run() {
		for (int i = 0; i < 1_000; i++) {
			Math.hypot(Math.pow(92456789, i), Math.cos(i));
		}
		count++;
	}

	public int getCount() {
		return count;
	}

}
