package com.zhuziym.char03.clone;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月23日 下午3:50:43
 *
 */
public class Pserson {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}
}
