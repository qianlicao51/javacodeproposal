package com.zhuziym.char09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: Client127.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 上午8:51:56
 *
 */
public class Client127 {
	public static void main(String[] args) throws Exception {
		/*
		 * runTasks(TaskWithLock.class); runTasks(TaskWithSync.class);
		 */
		lockTask();
	}

	private static void lockTask() {
		// 多个线程共享
		final Lock lock = new ReentrantLock();
		// 启动3个线程
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						lock.lock();
						Thread.sleep(2000);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}).start();
		}
	}

	static void runTasks(Class<? extends Runnable> clz) throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("开始执行" + clz.getSimpleName() + " 任务名称");
		// 启动三个线程
		for (int i = 0; i < 3; i++) {
			es.submit(clz.newInstance());
		}
		// 等待足够长的时间 然后关闭执行器
		TimeUnit.SECONDS.sleep(10);
		System.out.println("***" + clz.getSimpleName() + "任务执行完毕***\n");

		es.shutdown();

	}
}
