package com.zhuziym.char09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: TaskWithLock.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 上午8:47:03
 *
 */
public class TaskWithLock extends Task implements Runnable {

	// 声明显示锁
	private final Lock lock = new ReentrantLock();

	@Override
	public void run() {

		try {
			// 开始锁定
			lock.lock();
			doSomething();
		} finally {
			lock.unlock();
		}
	}
}
