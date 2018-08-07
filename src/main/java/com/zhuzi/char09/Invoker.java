package com.zhuzi.char09;

/**
 * @Title: Invoker.java
 * @Package com.zhuzi.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 下午10:12:02
 *
 */
public class Invoker {
	private Command command;
	public void setCommand(Command _command) {
		this.command = _command;
	}
	// 执行命令
	public void action() {
		this.command.execute();
	}
}
