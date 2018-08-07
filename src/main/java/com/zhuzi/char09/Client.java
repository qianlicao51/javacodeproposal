package com.zhuzi.char09;

/**
 * @Title: Client.java
 * @Package com.zhuzi.char09
 * @Description: TODO(场景类)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 下午10:17:49
 *
 */
public class Client {
	public static void main(String[] args) {
		//声明调用者
		Invoker invoker = new Invoker();
		//定义一个接收者
		Receiver receiver = new ConcreteReciver01();
		//定义接受命令的执行者
		Command command = new ConcreteCommand1(receiver);
		//执行
		command.execute();
	}
}
