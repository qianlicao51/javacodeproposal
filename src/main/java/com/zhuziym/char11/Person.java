package com.zhuziym.char11;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Title: Client141.java
 * @Package com.zhuziym.char11
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月15日 下午5:19:40
 *
 */
public class Person {

	private String name;
	private int age;

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("姓名", name).append("年龄", age).toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this || obj.getClass() == getClass()) {
			return true;
		}

		Person p = (Person) obj;
		// 姓名相同 认为两个对象相同
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(name, p.name).isEquals();
	}

	// hashCode
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	// ///////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {

	}

}
