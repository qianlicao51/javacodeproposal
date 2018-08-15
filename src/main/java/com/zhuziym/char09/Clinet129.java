package com.zhuziym.char09;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Title: Clinet129.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 下午2:48:03
 *
 */
public class Clinet129 {
	public static void main(String[] args) {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);

		for (int i = 0; i < 10; i++) {
			blockingQueue.add("");
			// Exception in thread "main" java.lang.IllegalStateException: Queue
			// full
		}
	}
}
