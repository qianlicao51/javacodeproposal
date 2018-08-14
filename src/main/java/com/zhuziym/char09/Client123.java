package com.zhuziym.char09;

/**
 * @Title: Client123.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午3:13:08
 *
 */
public class Client123 {
	public static void main(String[] args) throws InterruptedException {
		// 最大循环次数
		int value = 1000;

		// 循环次数，防止出现无线循环
		int loops = 0;
		// 主线程组，用于估计活动线程数
		ThreadGroup tg = Thread.currentThread().getThreadGroup();

		while (loops++ < value) {
			UnsafeThread ut = new UnsafeThread();
			for (int i = 0; i < value; i++) {
				new Thread(ut).start();
			}
			// 等待15毫秒，等待活动线程数量为1
			do {
				Thread.sleep(15);
			} while (tg.activeCount() != 1);

			if (ut.getCount() != value) {
				// 出现线程不安全的情况
				System.out.println("循环到第" + loops + " 次，出现线程不安全");
				System.out.println("此时count = " + ut.getCount());
				System.exit(0);
			}
		}
	}
}
