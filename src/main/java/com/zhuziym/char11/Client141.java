package com.zhuziym.char11;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import com.zhuziym.char03.clone.Pserson;

/**
 * @Title: Clinet141.java
 * @Package com.zhuziym.char11
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 下午5:11:19
 *
 */
public class Client141 {
	public static void main(String[] args) {
		// 判断是否为空
		StringUtils.isEmpty("");
		// 是否是数字
		StringUtils.isNumeric("12");
		// 统计子字符串出现的次数
		StringUtils.countMatches("abcd", "a");
		// 转义XML标示
		StringEscapeUtils.escapeXml("<project xmlns=http://maven.apache.org/POM/4.0.0 xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance xsi:schemaLocation");
		// 随机生成长度为6的ASCII字符串
		String randomAscii = RandomStringUtils.randomAscii(6);
		WordUtils.capitalize("abc bcd");

		// Object
		Person person = new Person();
		person.setAge(12);
		person.setName("grq");
		System.out.println(person);

	}
}
