package com.zhuzi.char08;
/**
 * @Title:  ConcreteMediatoe.java   
 * @Package com.zhuzi.char08   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 下午2:09:47
 *
 */
public class ConcreteMediator extends Mediator {
	@Override
	public void doSomething1() {
		//调用同事类，
		super.c1.selfMethod1();
		super.c2.selfMethod2();
	}

	@Override
	public void doSomething2() {
		super.c1.selfMethod1();
		super.c2.selfMethod2();
	}
}
