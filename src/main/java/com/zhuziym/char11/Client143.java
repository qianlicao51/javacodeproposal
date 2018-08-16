package com.zhuziym.char11;

import gnu.trove.decorator.TIntListDecorator;
import gnu.trove.function.TIntFunction;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TIntProcedure;
import it.unimi.dsi.fastutil.BigList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import com.zhuziym.char03.clone.Pserson;

import ch.lambdaj.Lambda;

/**
 * @Title: Client143.java
 * @Package com.zhuziym.char11
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者 grq
 * @version 创建时间：2018年8月16日 下午2:12:40
 *
 */
public class Client143 {
	public static void main(String[] args) {
		// fastUtil();
		trove();
		LambdaUtil();
	}

	private static void LambdaUtil() {
		List<Integer> list = new ArrayList<Integer>();

		// 计算平均值
		Lambda.avg(list);

		// 统计每个元素出现的次数，返回一个Map
		Map<Object, Integer> count = Lambda.count(list);

		// 按照年龄排序
		List<Person> perList = new ArrayList<Person>();
		perList.add(new Person("clhang", 24));
		perList.add(new Person("dou", 26));
		perList.add(new Person("agrq", 23));
		perList.add(new Person("bsunjie", 22));

		// 按照顺序排序 ()
		List<Pserson> sort = Lambda.sort(perList, Lambda.on(Person.class).getName());
		System.out.println(sort);

		// 串联所有元素指定属性，结果为 clhang, dou, agrq, bsunjie
		String name = Lambda.joinFrom(perList).getName();

		// 过滤年龄大于20的元素
		List<Person> select = Lambda.select(perList, new BaseMatcher<Pserson>() {
			@Override
			public boolean matches(Object _o) {
				Person p = (Person) _o;
				return p.getAge() > 23;
			}

			@Override
			public void describeTo(Description arg0) {
			}
		});

		// 查找出最大年龄
		int age = Lambda.maxFrom(perList).getAge();

		// 抽取出所有姓名组成一个数组 #[clhang, dou, agrq, bsunjie]
		List<String> extract = Lambda.extract(perList, Lambda.on(Person.class).getName());

		boolean exists = Lambda.exists(perList, new BaseMatcher<Person>() {

			@Override
			public boolean matches(Object item) {
				Person p = (Person) item;
				return p.getName().equals("agrq");
			}

			@Override
			public void describeTo(Description arg0) {
			}
		});
		System.out.println(exists);
	}

	/**
	 * trove
	 * <p>
	 * <dependency> <groupId>net.sf.trove4j</groupId>
	 * <artifactId>trove4j</artifactId> <version>3.0.3</version> </dependency>
	 * 
	 */
	private static void trove() {
		TIntArrayList intArrayList = new TIntArrayList();
		// 每个元素乘以2
		intArrayList.transformValues(new TIntFunction() {
			@Override
			public int execute(int value) {
				return value * 2;
			}
		});
		// 过滤大于200的元素
		intArrayList.grep(new TIntProcedure() {
			@Override
			public boolean execute(int value) {
				return value > 200;
			}
		});

		// 包装为JDK的list
		List<Integer> jdkList = new TIntListDecorator(intArrayList);

		// 键类型确定Map
		TIntObjectMap<String> map = new TIntObjectHashMap<String>();

	}

	/**
	 * fastutil
	 */
	private static void fastUtil() {

		// 明确键类型的Map
		Int2ObjectMap<String> map = new Int2ObjectOpenHashMap<String>();
		map.put(100, "grq");
		// java.lang.OutOfMemoryError
		BigList<String> bigList = new ObjectBigArrayBigList<String>(1L + Integer.MAX_VALUE);

		// 基本类型的集合，不再使用Intreger包装类型
		IntArrayList intArrayList = new IntArrayList();
	}
}
