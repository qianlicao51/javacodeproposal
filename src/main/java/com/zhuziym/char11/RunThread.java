package com.zhuziym.char11;

import java.util.concurrent.TimeUnit;

/**
 * @Title: RunThread.java
 * @Package com.zhuziym.char11
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月16日 上午7:57:54
 *
 */
public class RunThread implements Runnable {
	private String urlStr, file;

	public RunThread(String urlStr, String file) {

		this.urlStr = urlStr;
		this.file = file;
		Thread thread = new Thread(this);
		thread.setUncaughtExceptionHandler(new DownUncaugthEx());
		thread.start();
	}

	private class DownUncaugthEx implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("=======线程" + t.getName() + e.getMessage() + " 异常,重新启动====");
			new RunThread("url===", "saveFilePosition");
		}
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i < 10; i++) {
				TimeUnit.MILLISECONDS.sleep(1_000);
				System.out.println("运行的是第" + i + "次");
				if (i % 3 == 0) {
					throw new RuntimeException("衣带渐宽终不悔");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("淡泊明志，宁静致远");
		}

	}

	private void cal() {
		int i = 1 / 0;
	}

	public static void main(String[] args) {
		new RunThread("src==", "file");
	}
}
