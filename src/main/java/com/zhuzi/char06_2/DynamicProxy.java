package com.zhuzi.char06_2;

import java.lang.reflect.InvocationHandler;

import com.zhuzi.char06.Proxy;

/**
 * @Title:  DynamicProxy.java   
 * @Package com.zhuzi.char06_2   
 * @Description:    TODO(动态代理类)   
 * @author 作者 grq
 * @version 创建时间：2018年8月5日 下午1:32:02
 *
 */
public class DynamicProxy<T> {

	public static<T> T newProxyInstanct(ClassLoader lodaer, Class<?>[] interfac,InvocationHandler h){
		//寻找一个Joinpoint连接点，
		if(true){
			//执行一个前置通知
			new BeforeAdvice().exex();
		}
		return null;
	}
}
