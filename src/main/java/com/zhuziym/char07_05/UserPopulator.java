package com.zhuziym.char07_05;

/**
 * @Title: UserPopulator.java
 * @Package com.zhuziym.char07_05
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午7:49:08
 *
 */
public class UserPopulator extends AbsPopulator {

	@Override
	public void doInit() {
		System.out.println("初始化 用户表 操作");
	}

	public void initPassword() {
		System.out.println("初始化密码");
	}

	public void initJobs() {
		System.out.println("初始化工作任务");
	}
}
