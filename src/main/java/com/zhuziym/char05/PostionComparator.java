package com.zhuziym.char05;

import java.util.Comparator;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午4:45:16
 *
 */
public class PostionComparator  implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		//按照职位降序排序
		return o1.getPostion().compareTo(o2.getPostion());
	}

}
