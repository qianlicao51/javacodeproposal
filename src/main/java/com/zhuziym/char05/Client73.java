package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午4:31:51
 *
 */
public class Client73 {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>(5);
		list.add(new Emp(2, "lifneg", Postion.Manager));
		list.add(new Emp(1, "grq", Postion.Boss));
		list.add(new Emp(4, "taoshuai", Postion.Staff));
		list.add(new Emp(3, "sunjie", Postion.Manager));
		list.add(new Emp(5, "zhucaixi", Postion.Staff));

	  

		Collections.sort(list);

		for (Emp emp : list) {
			System.out.println(emp);
		}
		Collections.sort(list,Collections.reverseOrder(new PostionComparator()));
		 
	}
}
