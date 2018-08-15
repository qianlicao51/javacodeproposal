package com.zhuziym.char09;

/**
 * @Title: TaskWithSync.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 上午8:50:56
 *
 */
public class TaskWithSync extends Task implements Runnable {

	@Override
	public void run() {
		// 内部锁
		synchronized ("A") {
			doSomething();
		}

	}

}
