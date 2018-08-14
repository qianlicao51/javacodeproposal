package com.zhuziym.char08;

/**
 * @Title: Foo.java
 * @Package com.zhuziym.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 上午10:19:50
 *
 */
public class Foo {
	public static boolean m() {
		// 取得当前栈信息
		StackTraceElement[] sts = new Throwable().getStackTrace();
		// 检查是否是m1方法调用
		for (StackTraceElement st : sts) {
			if (st.getMethodName().equals("m1")) {
				return true;
			}
		}
		return false;
	}
}
