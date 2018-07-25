package com.zhuziym.char05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author 作者 grq
 * @version 创建时间：2018年7月25日 下午5:13:59
 *
 */
public class Client75 {
	public static void main(String[] args) {
		List<City> cities = new ArrayList<City>();
		City city = new City("021", "沪");
		City cs = new City("021", "上海");
		cities.add(cs);
		cities.add(city);

		// 排序
		Collections.sort(cities);
		System.out.println(cities);
		
		//查找对象
		int indexOf = cities.indexOf(cs);
		int binarySearch = Collections.binarySearch(cities, cs);
		
		System.out.println("索引值indexOf"+indexOf);
		System.out.println("索引值binarySearch"+binarySearch);
		
	}
}

class City implements Comparable<City> {
	// 城市编码
	private String code;
	// 城市名称
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj != this || obj.getClass() != getClass()) {
			return false;
		}
		City city = (City) obj;
		return new EqualsBuilder().append(code, city.code).isEquals();
	}

	@Override
	public int compareTo(City o) {
		return new CompareToBuilder().append(name, o.name).toComparison();
	}

	public City(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return   ToStringBuilder.reflectionToString(this);
	}

}
