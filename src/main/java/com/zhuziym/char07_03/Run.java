package com.zhuziym.char07_03;

import org.joda.time.DateTime;

/**
 * @Title: Run.java
 * @Package com.zhuziym.char07_03
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午6:36:39
 *
 */
public class Run implements Runnable {

	@Override
	public void run() {
		System.out.println("Run.run()" + new DateTime().toString("yyyy-MM-dd hh:mm:ss"));
	}

}
