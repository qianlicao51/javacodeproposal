package com.zhuziym.char09;

/**
 * @Title: MultiThread.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 上午10:39:44
 *
 */
public class MultiThread extends Thread {
	@Override
	public synchronized void start() {
		// super.start();
		//调用线程
		run();
	}
	@Override
	public void run() {
		System.out.println("MultiThread.run()");
	}
}
