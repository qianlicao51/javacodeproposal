package com.zhuziym.char11;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.MutableDateTime;

/**
 * @Title: Client142.java
 * @Package com.zhuziym.char11
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月16日 上午8:39:21
 *
 */
public class Client142 {
	static DateTime dateTime = new DateTime();
	static String formatYmdHms = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) {

		// 当前时间戳#2018-08-16T08:42:43.212+08:00

		// 输出英文星期#星期四
		dateTime.dayOfWeek().getAsShortText();
		// 英文星期#Thu
		dateTime.dayOfWeek().getAsShortText(Locale.ENGLISH);

		// 本地日期# 2018-08-16
		dateTime.toLocalDate();

		// 日期格式化#2018-08-16 08:49:47
		String string = dateTime.toString(formatYmdHms);

		convertDateJodaToJkd();
	}

	/**
	 * joda与jdk时间转换
	 */
	private static void convertDateJodaToJkd() {
		DateTime dt = new DateTime();

		// Joda转JDK 的date
		Date date = dt.toDate();
		// jdk 时间转joda
		DateTime time = new DateTime(date);
	}

	/**
	 * 时区
	 */
	private static void localDemo() {
		DateTime dt = new DateTime();
		// 此时东京时间
		DateTime withZone = dt.withZone(DateTimeZone.forID("Asia/Tokyo"));

		// 计算标准时间
		DateTime timeUTC = dt.withZone(DateTimeZone.UTC);
		System.out.println("当地时间-->" + dt.toString(formatYmdHms));
		System.out.println("标准时间-->" + timeUTC.toString(formatYmdHms));

	}

	/**
	 * 计算10年内的黑色星期五
	 */
	private static void easyCal() {
		MutableDateTime time = new MutableDateTime();
		DateTime plusYears = dateTime.plusYears(10);
		System.out.println(time.toString("yyyy-MM-dd"));
		while (time.isBefore(plusYears)) {
			if (time.dayOfMonth().get() == 13 && time.getDayOfWeek() == 5) {
				// 计算10年内的黑色星期5
				System.out.println("黑色星期5-->" + time.toString(formatYmdHms));
			}
			// 循环一次加一天
			time.addDays(1);
		}

	}

	/**
	 * 日期计算
	 */
	private static void calDate() {
		// 加上100小时是星期几
		dateTime.plusHours(100).dayOfWeek().getAsShortText();

		// 100天后今天
		String string2 = dateTime.plusDays(100).toString(formatYmdHms);

		// 相差天数
		Days.daysBetween(dateTime, new DateTime().plusDays(200));
	}
}
