package com.zhuziym.char08;

import java.util.zip.DataFormatException;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.zhuziym.char03.clone.Pserson;

/**
 * @Title: Client113.java
 * @Package com.zhuziym.char08
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月13日 下午8:16:16
 *
 */
public class Client113 {

	public static void main(String[] args) throws Exception {
		System.out.println(doStuff(-1));
		System.out.println(doStuff(100));
		System.out.println(val());
		System.out.println(modifyPserson().getName());
	}

	private static int doStuff(int i) throws Exception {

		try {
			if (i < 0) {
				throw new DataFormatException("数据格式错误");
			} else {
				return i;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return -1;
		}

	}

	/**
	 * 该方法返回值永远是1。
	 * 因为finally执行完毕后该方法已经有返回值了，后续代码块就不再
	 * 执行
	 * @return
	 */
	private static int val() {
		int a = 1;
		try {
			return a;
		} catch (Exception e) {
		} finally {
			a = -1;
		}
		return 0;
	}

	/**
	 * 此方法返回值永远都是“finally”，
	 * 因为Person是一个引用对象，在try代码块中的返回值是Person对象的地址，finally中再修改当然就是 finally
	 * @return
	 */
	public static Pserson modifyPserson() {
		Pserson p = new Pserson();
		p.setName("张三");
		try {
			return p;
		} catch (Exception e) {
		} finally {
			p.setName("finally");
		}

		p.setName("finally after");
		return p;
	}

	class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
		}

	}
}
