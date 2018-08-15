package com.zhuziym.char09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title: Foo.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 上午11:33:28
 *
 */
public class Foo {
	// 可重入的读写锁
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	// 读锁
	private final Lock rLock = rwl.readLock();

	// 写锁
	private final Lock wLock = rwl.writeLock();

	// 多操作，并发执行
	public void read() {
		try {
			rLock.lock();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rLock.unlock();
		}
	}

	// 写操作，同时只允许一个写操作
	public void write(Object obj) {
		try {
			wLock.lock();
			Thread.sleep(2000);
			System.out.println("Foo.write()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			wLock.unlock();
		}

	}
}
