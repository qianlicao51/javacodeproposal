package com.zhuzi.char09;

/**
 * @Title: ConcreteCommand1.java
 * @Package com.zhuzi.char09
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 下午10:07:41
 *
 */
public class ConcreteCommand2 extends Command {

	private Receiver receiver;

	// 构造函数传递接收者
	public ConcreteCommand2(Receiver receiver) {
		this.receiver = receiver;
	}

	// 执行一个命令
	@Override
	public void execute() {
		// 业务处理
		this.receiver.doSomething();
	}

}
