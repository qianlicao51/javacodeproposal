package com.zhuziym.char09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Title: Client126.java
 * @Package com.zhuziym.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午11:18:52
 *
 */
public class Client126 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		single();
	}

private static void single() throws InterruptedException, ExecutionException {
	ExecutorService es = Executors.newSingleThreadExecutor();

	Future<String> future = es.submit(new Callable<String>() {

		@Override
		public String call() throws Exception {
			return "thread";
		}
	});
	//获得任务执行返回值
	System.out.println(future.get());
	//关闭执行器
	es.shutdown();
}
}
