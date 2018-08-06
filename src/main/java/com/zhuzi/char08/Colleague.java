package com.zhuzi.char08;

/**
 * @Title: Colleague.java
 * @Package com.zhuzi.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月6日 下午2:12:56
 *
 */
//同事类
public abstract class Colleague {

	protected Mediator mediator;

	public Colleague(Mediator _meMediator) {
		this.mediator = _meMediator;
	}
}
