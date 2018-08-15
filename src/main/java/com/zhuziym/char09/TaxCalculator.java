package com.zhuziym.char09;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Title: TaxCalculator.java
 * @Package com.zhuziym.char09
 * @Description: TODO(税率计算器)
 * @author 作者 grq
 * @version 创建时间：2018年8月14日 下午3:28:08
 *
 */
public class TaxCalculator implements Callable<Integer> {
	// 本金
	private int seedMoney;

	public TaxCalculator(int seedMoney) {

		this.seedMoney = seedMoney;
	}

	@Override
	public Integer call() throws Exception {

		// 模拟复杂运算，运行一次10秒
		TimeUnit.MILLISECONDS.sleep(10_000);
		return seedMoney / 10;
	}
}
