package com.zhuzi.char08;

/**
 * @Title: ConcreteColleague1.java
 * @Package com.zhuzi.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 上午11:50:22
 *
 */
public class ConcreteColleague1 extends Colleague {

	// 通过构造函数传递中介者
	public ConcreteColleague1(Mediator _meMediator) {
		super(_meMediator);
	}

	// 自有方法 dep_method
	public void selfMethod1() {
	}

	// 依赖方法
	public void depMethod1() {
		// 处理自己的业务逻辑
		// 自己不能处理的业务逻辑，委托给中介者处理
		super.mediator.doSomething1();
	}
}
