package com.zhuziym.char09;

import java.util.Calendar;

/**
 * @Title: Task.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 上午8:42:25
 *
 */
public class Task {
	public void doSomething() {
		try {
			// 等待 2秒 ，此时的线程转为WAITING状态
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("线程名称：" + Thread.currentThread().getName());
		// 运行时间戳
		sbBuffer.append("，执行时间：" + Calendar.getInstance().get(13) + "s");
		System.out.println(sbBuffer);
	}
}
