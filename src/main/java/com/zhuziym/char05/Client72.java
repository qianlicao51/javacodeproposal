package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月24日 上午10:42:08
 *
 */
public class Client72{

	@Test
	public void testSubList() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<String> list =new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		List<String> subList = list.subList(0, 2);
		System.out.println(subList);
	}
}
