# javacodeproposal
> 秦小波《编写高质量代码之Java》学习
# 编写高质量代码建议


# 楔子

> 学习秦小波的《编写高质量代码之Java》，作个学习笔记。感谢遇到这么好的书籍。

## 第1章 Java开发通用方法和准则

### 建议1：不要在常量和变量中出现易混淆的字母

> 包名全小写，类名首字母全大写，
>
> 常量全部大写用下划线分割，
>
> 变量采用驼峰命名法

### 建议2：莫让常量蜕变成变量

> 这个建议可能使人大跌眼镜。通常的观念中常量不会变化，我在读此书之前也是这样认为的

```java
public class Client01 {
	public static void main(String[] args) {
		//TODO 下面这2个打印出来时相同的，我本以为是不同的。
		//TODO 但是多次运行，每次运行的结果是不一样的
		System.out.println("变化的常量" + Const.RAND_CONST);
		System.out.println("变化的常量" + Const.RAND_CONST);
	}
}

interface Const {
	// 变化的常量
	public static final int RAND_CONST = new Random().nextInt();
}
```

> 务必让常量在运行期间保持不变

### 建议3：三元操作符类型务必保持一致

```java
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i < 100 ? 90 : 100);
		String s1 = String.valueOf(i < 100 ? 90 : 100.0);
		System.out.println("两者是否相等" + s.equals(s1));
		System.out.println(s + "<>" + s1);
		// 两者是否相等false
		// 90<>90.0
	}
```

> 变量s1的情况就有点不同了，第
> 一个操作数是90（int类型），第二个操作数却是100.0，而这是个浮点
> 数，也就是说两个操作数的类型不一致，可三元操作符必须要返回一个
> 数据，而且类型要确定，不可能条件为真时返回int类型，条件为假时返
> 回float类型，编译器是不允许如此的，所以它就会进行类型转换了，int
> 型转换为浮点数90.0，也就是说三元操作符的返回值是浮点数90.0，那
> 这当然与整型的90不相等了。这里可能有读者疑惑了：为什么是整型转
> 为浮点，而不是浮点转为整型呢？这就涉及三元操作符类型的转换规
> 则：
> 	若两个操作数不可转换，则不做转换，返回值为Object类型。
> 若两个操作数是明确类型的表达式（比如变量），则按照正常的二
> 进制数字来转换，int类型转换为long类型，long类型转换为float类型

> 等。

### 建议4：避免带有变长参数的方法重载

### 建议5：别让null值和空值威胁到变长方法

```java
	public void method(String str, Integer... integers) {
	}

	public void method(String str, String... strs) {
	}

	public static void main(String[] args) {
		Clinet05 clinet = new Clinet05();
		clinet.method("GRQ", null);
	}
在上面代码中，方法重载使用null ,编译报错，可以使用下面的规避
	public static void main(String[] args) {
		Clinet05 clinet = new Clinet05();
		String[] strs = null;
		clinet.method("GRQ", strs);
	}
```

### 建议6：覆写变长方法也循规蹈矩

```java
public class Client06 {
	public static void main(String[] args) {
		//向上转型
		Base base = new Sub();
		base.fun(100, 50);
		
		//不转型
		Sub sub = new Sub();
		/*
		 * 此处报错
		 * 
		 * */
		sub.fun(100, 50);
	}
}

class Base {
	void fun(int price, int... discounts) {
		System.out.println("Base.fun()");
	}
}
class Sub extends Base {
	@Override
	void fun(int price, int[] discounts) {
		System.out.println("Sub.fun()");
	}
}
```

> ​	base对象十把子类对象Sub做了向上转，形参列表是由父类决定的，由于是变长参数，在编译
>
> 时，base.fun(100,50)中 50 会被编译器猜测而编译为{50} 数组，再由子类Sub执行。
>
> ​	子类直接调用时，编译器不会吧50 做类型转换，因为数组本身也是一个对象，编译器不会爱两个没有继承关系之间的类做转换，类型不匹配自然拒绝执行，给与错误。

### 建议7 警惕自增的陷阱

```java
	public static void main(String[] args) {
		int count = 0;

		for (int i = 0; i < 10; i++) {
			count = count++;
		}
		System.out.println("count =" + count);
	}
	// 结果是 0
//count++ 的返回值是自加之前的值，修改为  count++ 及是自增
//C++中的count=count++ 与count++是等价的


```

### 建议8：不要让旧语法困扰你

###  建议9：少用静态导入 

> 对与静态导入，一般遵循2个规则。
>
> 1 不要使用* 通配符，除非是静态导入常量类
>
> 2 方法名具有明确、清晰 表象意义的工具

### 建议10 不要在本类覆盖静态导入的变量和方法

### 建议11：养成良好习惯，显示声明UID

> 类实现Serializable接口是为了可持久化，比如网络传输或者本地存储，为系统的分布和异构部署提供了先决条件，若没有序列化，我们熟悉的远程调用、对象数据库都可能不存在、
>
> serialVersionUID

### 建议12 避免序列化类在构造函数中为不变量赋值

> 反序列化时 ，构造函数不会执行。
>
> 在序列化类中，不要使用构造函数为final变量赋值

### 建议13 避免为final变量复杂赋值

### 建议14 使用序列化类的私有方法巧妙解决部分属性持久化问题

### 建议15 break万万不可忘

case 语句后面随手写上break，养成良好的习惯

> Performaces→Java→Compiler→Errors/Warnings→Potential Programming
> problems，然后修改'switch' case fall-through为Errors级别，如果你胆敢不
> 在case语句中加入break，那Eclipse直接就报个红叉给你看，这样就可以
> 完全避免该问题的发生了。





### 建议16 易变业务使用脚本语言编写





### 建议17 慎用动态编译



### 建议18 避免instanceof非预期结果



### 建议19 断言绝对不是鸡肋



### 建议20 不要只替换一个类

> 发布应用系统时禁止使用类文件替换方式。整体WAR包发布才是万全之策





## 第2章 基本类型



### 建议21 用偶判断，不用奇判断

```java
	public static void main(String[] args) {
		System.out.println(remainder(5, 2));// 1
		System.out.println(remainder(4, 2));// 0
		System.out.println(remainder(-1, 2));// -1
	}

	//模拟取余计算，
	static int remainder(int dividend, int divisor) {
		return dividend - dividend / divisor * divisor;
	}

计算-1 时，得到的结果是不是1 ，按照用奇判断 则就是偶数了，显然不对.
```





### 建议22 用整数类型处理货币

```java
	public static void main(String[] args) {
		//0.40000000000000036
		System.out.println(10.00 - 9.60);
	}

// 计算机中浮点数可能是不准确的，它无限接近准确值，而不完全精准。
//0.4这个十进制小数转换为二进制，不能使用二进制准确的表示

1)使用 BigDecimal
2)使用整形  把参与运算的值扩大100倍


```

### 建议23 不要使用默认类型

> java是先运算然后再进行类型转换的，如果int相乘超过了int最大值，就是负数了，再转为long,还是负数

### 建议24 边界

```java
	// 一个会员拥有产品最多数量
	public final static int LIMIT = 2000;

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);// 2147483647
		int cur = 1000;
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入需要预定的数量");
		while (scanner.hasNextInt()) {
			int order = scanner.nextInt();
			// 当前拥有的与预定产品的数量和
			if (order > 0 && order + cur <= LIMIT) {
				System.out.println("预定产品个数为:" + order);
			} else {
				System.out.println("超过最大限额，预定失败");
			}
		}

	}
//输入 int的最大值 2147483647 ，在加上1000，会超出int范围，结果是负数，那就小于2000
```

### 建议25 不要让四舍五入亏一方

> 故事的引入可以说是“银行家舍入”，规则如下：
>
> ​	四舍六入五考虑，五后非零就进一，五后为零看奇偶，五前为偶应舍去，五前为奇要进一
>
> eg:保留2位精度
>
> ​	round(10.5551)=10.56
>
> ​	round(10.555)=10.56
>
> ​	round(10.545)=10.54
>
> 目前Java支持以下七种舍入方式：
> 	1)ROUND_UP：远离零方向舍入。
> 向远离0的方向舍入，也就是说，向绝对值最大的方向舍入，只要舍弃位非0即进位。
> 	2)ROUND_DOWN：趋向零方向舍入。
> 	向0方向靠拢，也就是说，向绝对值最小的方向输入，注意：所有的位都舍弃，不存在进位情况。
> 	3)ROUND_CEILING：向正无穷方向舍入。
> 	向正最大方向靠拢，如果是正数，舍入行为类似于ROUND_UP；如果为负数，则舍入行为类ROUND_DOWN。注意：Math.round方法使用的即为此模式。
> 	4)ROUND_FLOOR：向负无穷方向舍入。
> 向负无穷方向靠拢，如果是正数，则舍入行为类似于ROUND_DOWN；如果是负数，则舍入行为类似于ROUND_UP。
> 	5)HALF_UP：最近数字舍入（5进）。
> 这就是我们最最经典的四舍五入模式。
> 	6)HALF_DOWN：最近数字舍入（5舍）。
> 	在四舍五入中，5是进位的，而在HALF_DOWN中却是舍弃不进位。
> 	7)HALF_EVEN：银行家算法。
> 	在普通的项目中舍入模式不会有太多影响，可以直接使用Math.round方法，但在大量与货币数字交互项目中，一定要选择好近似的计算模式，尽量减少因算法不同而造成的损失。

### 建议26 提防包装类型null值

```java
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(null);
		calcSum(list);

	}

	public static int calcSum(List<Integer> list) {
		int count = 0;
		for (Integer integer : list) {
			count += integer;
		}
		return count;
	}
```

### 建议27 谨慎包装类型的大小比较





### 建议28 优先使用整形池





### 建议29 优先选择基本类型



### 建议30 不要随便设置随机种子



## 第3章 类、对象以方法

### 建议31 在接口中不要存在实现代码





### 建议32 静态变量一定要先声明后赋值



### 建议33 不要覆写静态方法



### 建议34 构造函数尽量简化



### 建议35 避免在构造函数中初始化其他类





### 建议36 使用构造代码块精炼程序

- 静态代码块

  用在静态变量的初始化或者创建前的环境初始化

- 同步代码块

  使用synchronized关键字修饰，并使用{}。它表示同一时间只有一个线程进入到该代码块中，是一种多线程保护机制

- 改造代码块

  在类中没有任何前缀或者后缀。使用{}。

  编译器会把构造代码块放在每个构造函数最前端。构造代码块会在每个构造函数内首先执行，不是在构造函数之前运行的，它依托于构造函数执行。

  构造函数应用场景。

  1) 初始化实例变量

  2) 初始化实例环境

### 建议37 构造代码块会想你所想



### 建议38 使用静态内部类提高封装性





### 建议39 使用匿名类的构造函数





### 建议40 匿名类的构造函数很特殊



### 建议41 让多重继承成为现实





### 建议42 让工具类不可实例化

> Java工具类一般使用private 修饰构造函数，但是使用反射依旧可以对象来访问。
>
> 可以用private修饰的同时 在抛异常的方法限制访问。可以保证工具类不会实例化

### 建议43 避免对象的浅拷贝

> 一个类实现了 Cloneable接口就表示它具备了被拷贝的能力，如果再覆写clone()方法就会完全具备拷贝能力。拷贝是在内存中进行的，`所以性能方面比直接通过new生成对象要快很多`，特别是在大对象的生成上，这样会使性能提升显示。

```shell
#浅拷贝(也叫做影子拷贝)存在对象属性不测底拷贝的问题
```

```shell
#拷贝的规则如下：
1） 基本类型
如果变量是基本类型，则拷贝其值，比如float,int
2)对象拷贝
#如果变量是一个实例对象，则拷贝引用地址，也就是说此时新拷贝出的对象与原对象共享实例变量，不受访问权限的限制。(你可以想象一下，一个private修饰的变量，竟然可以被2个不同实例对象访问，这让ava情何以堪)
3）String字符串
这个比较特殊，拷贝的也是一个地址，是个引用，但是在修改时，
它会从字符串池（String Pool）中重新生成新的字符串，原有的字符串
对象保持不变，在此处我们可以认为String是一个基本类型。
```

### 建议44 推荐使用序列化实现对象的拷贝

```shell
# 其实可以通过序列化方式来处理。在内存中通过字节流的拷贝来实现，也就是把母对象写到一个字节流中，在从字节流中将其读出来，这样就可以重建一个新对象了，该对象和母对象之间不存在引用共享的问题，也就相当于深拷贝一个新对象了。

```

[一个关于拷贝的博客](https://www.cnblogs.com/exceptioneye/p/4852962.html)

```java
public class CloneUtils {
	public static <T extends Serializable> T clone(T obj) {

		// 拷贝产生的对象
		T clonedObj = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oss = new ObjectOutputStream(baos);
			oss.writeObject(obj);
			oss.close();

			// 分配内存空间，写入原始对象，生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);

			// 返回新对象 并做类型转换
			clonedObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clonedObj;
	}
}
//此工具类 要求被拷贝的对象必须实现 Serializable接口。
//还需要注意的2点
//1)对象的内部属性都是可序列化的。如果有内部属性不可序列化，则会抛出序列化异常，这会让调试者很纳闷：生成一个对象怎么会出现序列化异常呢？从这一点来考虑，也需要把CloneUtils工具的异常进行细化处理
//2)注意方法和属性的特殊修饰符

```

```shell
# 采用序列化方式拷贝还有一种等简单的方法，使用Apache 的 commons工具包的SerializationUtils,直接使用更加简洁方便(读到此处我不清楚是 commons-lang 里面的 还是 commons-lang3里面的)

```

### 建议45 覆写equals方法时不要识别不出自己



### 建议47 equals应该考虑null值情景

> 在覆写equals时建议使用getClass进行类型判断，而不要使用instanceof

### 建议48 覆写equals方法必须覆写hashCode方法

```java
public class Pserson {
	private String name;
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}
}
//其中HashCodeBuilder是org.apache.commons.lang.builder包下的一个哈希码生成工具
```

### 建议49 推荐覆写toString方法

> java 打印对象默认不友好。

### 建议50 使用package-info类为包服务



### 建议51 不要主动进行垃圾回收

## 第4章 字符串

### 建议52 推荐使用String直接量赋值





### 建议53 注意方法中传递的参数要求

```java
	public static void main(String[] args) {
		String string = "好是好啊";
		System.out.println(string.replace("是", ""));//好好啊
		
		String string2 = "$是$好$";
		//参数要求是正则
		System.out.println(string2.replaceAll("$", ""));//$是$好$
	}
```

### 建议54 正确使用Stirng StringBuffer StringBuilder

> 在性能方面，String类的操作要远慢于StringBuffer和StringBuilder

应用场景

- String应用场景

  在字符串不经常变化的场景中，例如常量声明，小量的变量运算

- StringBuffer应用场景

  频繁进行字符串(拼接，替换，删除)，并运行在多线程的环境中。例如XML解析、HTTP参数解析和封装等。

- StringBuilder应用场景

  在频繁进行字符串的运算（如拼接、替换、删除等），并且运行在单线程的环境中，则可以考虑使用StringBuilder，如SQL语句的拼装、JSON封装等。



### 建议55 注意字符串的位置



### 建议56 自由选择字符串拼接方法

> 在拼接时，append方法最快，concat方法次之，加好最慢。
>
> 通常情况下，“+”非常符合我们编码习惯。只有在系统性能临界时才考虑concat或者append

### 建议57 推荐在复杂字符串操作中使用正则表达式





### 建议58 强烈建议使用UTF编码



### 建议59 对字符串排序持一种宽容的心态



## 第5章 数组和集合

### 建议60 性能考虑，数组是选



### 建议61 若有必要，使用变长数组

```java
public static <T> T[] expandCapactiy(T[] datas, int newLen) {
		// 不能是负值
		newLen = newLen < 0 ? 0 : newLen;
		// 生成一个新数组，并拷贝原值
		return Arrays.copyOf(datas, newLen);

	}
```

### 建议62 警惕数组的浅拷贝

> 通过上诉copyOf 拷贝是浅拷贝





### 建议63 在明确的场景下，为集合指定初始容量



### 建议64 多种最值算法，适时选择



### 建议65 避开基本类型数组转换列表陷阱

```java
	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5 };
		List<int[]> asList = Arrays.asList(data);
		System.out.println("列表中元素个数" + asList.size());
		// 列表中元素个数1
		Integer[] datas = { 1, 2, 3, 4, 5 };
		List<Integer> asLists = Arrays.asList(datas);
		System.out.println("列表中元素个数" + asLists.size());
		// 列表中元素个数5
	}

```

> 原始类型数组不能作为asList的输入参数，否则会引起程序逻辑混乱。

### 建议66 asList方法产生的List对象不可更改

```java
 public static <T> List<T> asList(T... a) {
 	 return new ArrayList<>(a);
 }


```





### 建议67 不同的列表选择不同的遍历方法

> ArrayList 遍历时采用下标方式会提升性能




### 建议68 频繁插入和删除时使用LinkedList

1）插入

​	插入时 LinkedList效率比ArrayList快50倍

2）删除元素

​	LinkedList与ArrayList之间的PK，其中LinkedList胜两局：删除和插入效率高；ArrayList胜一局：修改元素效率高。总体上来说，在“写”方面，LinkedList占优势，而且在实际使用中，修改是一个比较少的动作。因此，如果有大量的写操作（更多的是插入和删除动作），推荐使用LinkedList。

​	

​	

### 建议69 列表相等只需关心元素数据





### 建议70 子列表只是原列表的一个视图



### 建议71 推荐使用subList处理局部列表

```java
	public static void main(String[] args) {

		// 删除数组 20·30 元素
		// 初始化一个固定长度，不可变列表
		List<String> listData = Collections.nCopies(100000, "grq");
		//变为可变数组
		List<String> list = new ArrayList<String>(listData);
		long start = System.currentTimeMillis();
		for (int i = 20; i < 30; i++) {
			list.remove(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
 
		List<String> list2 = new ArrayList<String>(listData);
		start = System.currentTimeMillis();
		list2.subList(20, 30).clear();
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
// subList所有的操作都是在原始的列表上进行的，那先用subList取出一个子列表，然后清空。
```

### 建议72 生成子类表后不要在操作原列表

​	针对sbuList来说。





### 建议73 使用Comparator进行排序

​	排序一般有2种方式时间，1是Comparable接口 2是Comparator接口。

```java
//实体类
public class Emp implements Comparable<Emp> {
	// 根据id 排序
	private int id;
	private String name;
	private Postion postion;


	@Override
	public int compareTo(Emp o) {
		// 正序
		// return new CompareToBuilder().append(id, o.id).toComparison();
		return new CompareToBuilder().append(postion, o.postion)// 职位排序
				.append(id, o.id)// 工号排序
				.toComparison();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

//
public enum Postion {
	Boss, Manager, Staff
}
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
```

> Comparable接口可以作为实现类的默认排序法，
>
> Comparator接口则是一个类的扩展排序工具。

​	

### 建议74 不推荐使用binarySearch对列表进行检索

```java
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	list.add("上海");
	list.add("广州");
	list.add("广州");
	list.add("北京");
	list.add("天津");
	System.out.println(list);
	System.out.println(list.indexOf("广州"));
	// 二分法查找
	System.out.println(Collections.binarySearch(list, "广州"));

	/*
	 * [上海, 广州, 广州, 北京, 天津] 1 2
	 */
}
//错误的原因在于：二分法查询的一个前提是，数据已经升序排列。否则二分法查找结果不准确。
```





### 建议75 集合中的元素必须做到compareTo和equals同步

```java
// indexOf是通过equals方法判断的，equals等于true就认为是找到符合的元素了
//binarySearch 是通过conpateTo方法返回值，返回值为0 就认为是找到符合的元素了
```





### 建议76 集合运算是使用更加优雅的方式

```java
public static void main(String[] args) {
	List<String> aList = new ArrayList<String>();
	aList.add("A");
	aList.add("B");
	aList.add("C");
	aList.add("V");
	List<String> bList = new ArrayList<String>();

	bList.add("B");
	bList.add("C");
	bList.add("BB");

	// 并集：也叫做合计，把两个集合加起来
	// aList.addAll(bList);

	// 交集：计算两个集合共有的元素
	// aList.retainAll(bList);

	// 差集：由所有属于A但是不属于B的元素组成的集合(从A中删除B)
	// aList.removeAll(bList);

	// 无重复的并集(1:删除B在A出现的元素；2:把剩余的B元素加到A)
	bList.removeAll(aList);
	aList.addAll(bList);
	System.out.println(aList);

}
```





### 建议77 使用shuffle打乱列表

```java

```

> 使用suffle 即可打算一个列表顺序。
>
> 可以用在程序伪装、抽奖程序、安全传输方面





### 建议78 减少HashMap中元素的数量

> 内存溢出问题，经常与HashMap有关。例如在使用缓存操作数据时，大批量的增删查该 会让内存溢出。



### 建议79 集合中的哈希码不要重复



### 建议80 多线程使用Vector或HashTable





### 建议81 非稳定排序推荐使用list





### 建议82 由点及面，一叶知秋——集合大家族 





## 第6章 枚举和注解

### 建议83 推荐使用枚举定义常量

```shell
# 枚举与类常量和静态常量相比，优势
#1）枚举常量更简单
#	枚举常量只需要定义每个枚举项，不需要枚举值。
#2）枚举常量属于稳定态
#3）枚举具有内置方法
#4）枚举可以自定义方法

```

```java
public class Client83 {
	public static void main(String[] args) {
		for (Season season : Season.values()) {
			System.out.println(season);
		}
	}
}

enum Season {
	Spring, Summer, Autumn, Winter;
}
```

### 建议84 使用构造函数协助描述枚举项





### 建议85 小心switch带来的空指针异常





### 建议86 在switch的default代码块中增加AssertionError错误



> 为了避免枚举增加了枚举值，而没修改switch导致错误





### 建议87 使用valueOf前必须进行校验

```java
public class Client87 {
	public static void main(String[] args) {
		List<String> asList = Arrays.asList("Spring", "summer");

		for (String name : asList) {
			// 查找字面值与ame相同的枚举项

			Season season = Season.valueOf(name);
			if (season != null) {
				System.out.println(season);
			} else {
				System.out.println("没有相关枚举项");
			}
		}
	}
}
/*Spring
Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.zhuziym.char06.Season.summer
	at java.lang.Enum.valueOf(Enum.java:238)
	at com.zhuziym.char06.Season.valueOf(Client83.java:1)
	at com.zhuziym.char06.Client87.main(Client87.java:18)
	
	summer (s小写)无法转换为Season枚举，抛出异常。
*/
```

上述异常解决办法

```java
// 1 try catch捕获异常
// 2 扩展枚举类
enum Season {
	Spring, Summer, Autumn, Winter;
	// 是否包含指定名称的枚举项
	public static boolean contains(String name) {
		// 所有的枚举值
		Season[] values = values();
		for (Season season : values) {
			if (season.name().equals(name)) {
				return true;

			}

		}
		return false;
	}
}

```



### 建议88 用枚举实现工厂方法模式更简洁





### 建议89 枚举项数量限制在64个以内





### 建议90 小心注解继承





### 建议91 枚举和注解结合威力更大





### 建议92 注意@Override不同版本的区别





## 第7章 泛型和反射



### 建议93 Java的泛型是类型擦除的 

```java
public class Client93 {
	public void arrayMethod(String[] strArray) {
	}

	public void arrayMethod(Integer[] intArray) {
	}


	public void listMethod(List<Integer> intList) {
	}
	public void listMethod(List<String> intList) {
	}
}
//上传编译不过 ，在编译后所有的泛型都会做相应的转化
//List<String> List<Integet> List<T>擦除后的类型为List
// List<String>[] 擦除后的类型为list[]

```



### 建议94 不能初始化泛型参数和数组



### 建议95 强制声明泛型的实际类型





### 建议96 不同的场景使用不同的泛型通配符



### 建议97 警惕泛型是不能协变和逆变的



### 建议98 建议采用的顺序是List<T> 、List<?> 、List<Object> 

###   



### 建议99 严格限定泛型类型采用多重界限





### 建议100 数组的真实类型必须是泛型类型的子类型



### 建议101 之一Class类的特殊性



- 无构造函数。一般的类都有构造函数，用于创建对象，但是Class类却没有构造函数，不能实例化，Class对象是在加载类时由Java虚拟机通过类加载器中的defineClass方法自动构造的
- 可描述基本类型。8个基本类型在JVM中并不是一个对象，他们一般存在于栈内存中，但是Class类任然可以描述他们，例如使用int.class表示int类型的对象



#### 获得一个Class对象的3种途径

```shell
# 1 类属性方式 如String.class
# 2对象的getClsas 方法
# 3 forName的方法加载   Class.forName("")



```



### 建议102 适时选择getDeclaredxxx 和getxxx



```java
public static void main(String[] args) throws Exception {

	// 方法名称
	String methodName = "doStuff";
	// TODO 获取自身类的所有方法，包括 public 私有 而写不受限于访问权限
	Method declaredMethod = Foo.class.getDeclaredMethod(methodName);
	// TODO getMethod 获得的是publc 访问级别 的方法(包括从父类继承过来的方法)
	Method method = Foo.class.getMethod(methodName);
}

```



```java
public static void main(String[] args) {
	Method[] methods = Dog.class.getMethods();
	Method[] declaredMethods = Dog.class.getDeclaredMethods();

	// 反射到父类 再次获取通过继承得到的父类上的方法
	Class<? super Dog> superclass = Dog.class.getSuperclass();
	System.out.println(superclass.getName());
	for (Method method : methods) {
		System.out.println(method.getName());
	}
}
```



### 建议103 反射访问属性或者方法时将Accessible设置为true





`method.setAccessible(true)` 通常我们放射时这样设置方法是否可被执行。如下

```java
public static void main(String[] args) throws Exception, SecurityException {

	// 反射获得方法
	Method method = Foo.class.getMethod("doStuff");
	// 打印方法可访问性
	System.out.println(method.isAccessible());
    //设置方法可访问性
	method.setAccessible(true);
	method.invoke(new Foo());
	/*
	 * 结果
	 * false
	Client103.Foo.doStuf()*/

}
```

但是 `Foo`代码如下，修饰符是`public` ，没有雨限制

```java
public class Foo {
	public final void doStuff() {
		System.out.println("Client103.Foo.doStuf()");
	}
}
```



**Accessible的属性并不是我们语法层级理解的访问权限，而是指是否更容易获得，是否进行安全检查。**



### 建议104 使用forName动态加载类文件

`动态加载（Dynamic Loading）是指程序运行时加载需要的类库文件，对Java程序来说，一般情况下，一个类文件在启动或者首次初始化时被加载到内存中，而反射则可以在运行时在决定是否要加载一个类，然后JVM加载并初始化，这就是动态加载 `

`一个类文件只有被加载到内存后才能生成实例对象，也就是一个对象的生成必定经历以下2个步骤`

```shell
# 1 加载到内存中生成Class的实例对象
# 2 通过new 关键字生成实例对象
```



#### 动态加载的意义

```shell
# 加载一个类即表示要初始化该类的static变量，特别是 static代码块
# ，这里我们可以做大量工作，比如注册自己，初始化环境
```

```java
public class Utils {
	static {
		System.out.println("Clinet104.Utils.enclosing_method()");
	}
}
public class Clinet104 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.zhuziym.char07.Utils");
	}
}
//打印结果
//Clinet104.Utils.enclosing_method()
//Utils 我们没有初始化，只是经过Class.forName就打印了语句
//这是因为Utils类被加载后，JVM会自动初始化其static 变量 和static
// 代码块，这是类加载机制决定的
```

`上述这种动态加载，最经典的就是在数据库驱动程序的加载代码片中`



`forName只是加载类，并不执行任何代码`





### 建议105 动态加载不适合数组



```shell
# forName动态加载，必须是一个类(8种基本数据类型除外，它们不是一
#个类)；其次，它必须有可追索的类路径
```

#### 如何动态加载一个数组

```shell
# 使用Array数组反射类动态加载

```

```java
public static void main(String[] args) {
	// 动态创建数组
	String[] strs = (String[]) Array.newInstance(String.class, 8);
	// 创建一个多维数组
	int[][] ints = (int[][]) Array.newInstance(int.class, 2, 3);
}
```





### 建议106 动态代理可以使代理模式更加灵活

