package com.zhuzi.char08;

/**
 * @Title: Mediator.java
 * @Package com.zhuzi.char08
 * @Description: TODO(通用抽象中介者)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 上午11:42:13
 *
 */
public abstract class Mediator {
	// 定义同事类
	protected ConcreteColleague1 c1;
	protected ConcreteColleague2 c2;

	//通过get/set设置同事类
	public ConcreteColleague1 getC1() {
		return c1;
	}
	public void setC1(ConcreteColleague1 c1) {
		this.c1 = c1;
	}
	public ConcreteColleague2 getC2() {
		return c2;
	}
	public void setC1(ConcreteColleague2 c2) {
		this.c2 = c2;
	}
	//中介者模式的业务逻辑
	public abstract void doSomething1();
	public abstract void doSomething2();
}
