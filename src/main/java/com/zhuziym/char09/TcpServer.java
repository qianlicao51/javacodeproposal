package com.zhuziym.char09;


/**
 * @Title: TcpServer.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 上午11:34:37
 *
 */
public class TcpServer implements Runnable {

	// 创建后立即运行
	public TcpServer() {

		Thread thread = new Thread(this);
		thread.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
		thread.start();
	}

	// 异常处理器
	private static class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// 记录线程异常信息
			System.out.println("线程" + t.getName() + "出现异常，自行重启");
			e.printStackTrace();
			// 重启线程，保证业务不中断
			new TcpServer();
		}

	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("系统组成运行");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 抛出异常
			throw new RuntimeException("淡泊明志，宁静致远");
		}
	}
}
