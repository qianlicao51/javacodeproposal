package com.zhuziym.char07_05;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Title: AbsPopulator.java
 * @Package com.zhuziym.char07_04
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午7:46:15
 *
 */
public abstract class AbsPopulator {
	// 模版方法
	public final void dataInitaling() throws Exception {

		Method[] methods = getClass().getMethods();
		for (Method method : methods) {
			if (isInitDateMethod(method)) {
				method.invoke(this);
			}
		}
	}

	/**
	 * 判断时候是数据初始化方法，基本方法鉴别器
	 */
	private boolean isInitDateMethod(Method m) {

		return m.getName().startsWith("init")// init 开始
				&& Modifier.isPublic(m.getModifiers())// 公开方法
				&& m.getReturnType().equals(Void.TYPE)// 返回值是void
				&& m.isVarArgs()// 输入参数为空
				&& Modifier.isAbstract(m.getModifiers());// 不能是抽象方法

	}

	// 基本方法
	protected abstract void doInit();

}
