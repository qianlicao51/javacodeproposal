package com.zhuzi.char02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: ProductFactory.java
 * @Package com.zhuzi.char02
 * @Description: TODO(延迟加载工厂类)
 * @author 作者 grq
 * @version 创建时间：2018年8月4日 下午4:53:07
 *
 */
public class ProductFactory {
	private static final Map<String, Product> prMap = new HashMap<String, Product>();

	public static synchronized Product createProduct(String type) throws Exception {
		Product product = null;
		if (prMap.containsKey(type)) {
			product = prMap.get(type);

		} else {
			if (type.equals("pro1")) {
				product = new ConcreProduct1();
			} else {
				product = new ConcreProduct2();
			}
		}
		return product;
	}
}
