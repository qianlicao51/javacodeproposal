package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午6:24:50
 *
 */
public class Client77 {
public static void main(String[] args) {
	List<String> aList = new ArrayList<String>();
	aList.add("A");
	aList.add("B");
	aList.add("C");
	aList.add("D");
	aList.add("V");

	System.out.println(aList);
	Collections.shuffle(aList);
	System.out.println(aList);				
}
}
