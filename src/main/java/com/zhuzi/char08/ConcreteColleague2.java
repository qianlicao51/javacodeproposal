package com.zhuzi.char08;

/**
 * @Title: ConcreteColleague2.java
 * @Package com.zhuzi.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 上午11:50:44
 *
 */
public class ConcreteColleague2 extends Colleague {
 
	
	public ConcreteColleague2(Mediator _meMediator) {
		super(_meMediator);
	}

	public void selfMethod2() {
		// 处理自己的业务逻辑
	}
	public void depMethod2(){
		//处理自己的业务逻辑
		//自己不能处理的，委托中介者处理
		super.mediator.doSomething2();
	}
}
