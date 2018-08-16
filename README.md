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



​	Java的反射框架提供了动态代理机制，允许在运行期对目标类生成代理，避免重复开发。

​	一个静态代理是通过`代理主题角色(Proxy)`  和 `具体主题角色(Real Subject)`  共同实现抽象主题`Subject`的逻辑，只是`代理主题角色把相关执行逻辑委托给了具体主题而已`，一个简单的静态代理如下：

---------------

==================抽象主题类

```java
public interface Subject {
	public void request();
}

```



==================具体主题角色

```java
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("RealSubject.request()");
	}

}
```

==================代理主题角色

```java
public class Proxy implements Subject {

	// 要代理哪个实现类
	private Subject sub = null;

	public Proxy(Subject sub) {
		this.sub = sub;
	}

	@Override
	public void request() {
		this.before();
		sub.request();
		this.after();
	}

	/**
	 * 预处理
	 */
	public void before() {
		System.out.println("Proxy.before()");
	}

	/**
	 * 善后处理
	 */
	public void after() {
		System.out.println("Proxy.after()");
	}
}
```

-----

==================动态代理

​	Java还提供了`java.lang.reflect.Proxy` 用于实现动态代理；只是提供`一个抽象主题角色` 和 `具体主题角色`  ，就可以动态实现其逻辑。

==================抽象主题角色

```java
public interface Subject {
	public void request();
}
```





==================具体主题角色

```java
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("RealSubject.request()");
	}

}
```

==================

```java
public class SubjectHandler implements InvocationHandler {
	//被代理对象
	private Subject sub;

	public SubjectHandler(Subject sub) {
		super();
		this.sub = sub;
	}

	// 委托处理方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("SubjectHandler.invoke()--预处理");
		// 直接调用被代理类的方法
		Object object = method.invoke(sub, args);
		System.out.println("SubjectHandler.invoke()--后处理");
		return object;
	}

}
```



​	此处没有了主题代理角色，取而代之的是`SubjectHandler`作为主要的逻辑委托处理，其中`invoke`方法是接口`InvocationHandler`定义必须实现的。完成对真实方法的调用。

==================场景类

```java
public class Client106 {
	public static void main(String[] args) {

		// 具体主题角色，也就是被代理类
		Subject subject = new RealSubject();

		// 代理实例的处理 handler
		SubjectHandler handler = new SubjectHandler(subject);

		// 当前加载器
		ClassLoader classLoader = subject.getClass().getClassLoader();

		// 动态代理
		Subject proxyInstance = (Subject) java.lang.reflect.Proxy.newProxyInstance(classLoader, subject.getClass().getInterfaces(), handler);

		// 执行具体主题角色的方法
		proxyInstance.request();

	}
}
```





### 建议107 使用反射增加装饰模式的普适性



​	装饰模式就是动态地给一个对象添加一些额外的职责。`使用Java的动态代理可以实现装饰模式的效果，而且其灵活性、适应性更强。`

​	以卡通《猫和老鼠》为例。

```java
// 
public interface Animal {
	public void soStuff();
}
```

```java
//老鼠
public class Rat implements Animal {

	@Override
	public void soStuff() {
		System.out.println("Jerry will paly with tom");
	}

}
```

```java
//给老鼠增加能力
public interface Feature {
	// 定义某种能力
	void load();
}
public class DigFeature implements Feature {

	@Override
	public void load() {
		System.out.println("钻地能力……");
	}

}
public class FlyFeature implements Feature {

	@Override
	public void load() {
		System.out.println("增加飞行能力……");
	}

}

```

 `包装动作类`

```java
public class DecorateAnimal implements Animal {

	// 被包装的动物
	private Animal animal;

	// 使用哪一个包装器
	private Class<? extends Feature> clz;

	public DecorateAnimal(Animal animal, Class<? extends Feature> clz) {
		this.animal = animal;
		this.clz = clz;
	}

	@Override
	public void soStuff() {
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object obj = null;
				// 设置包装条件
				if (Modifier.isPublic(method.getModifiers())) {
					obj = method.invoke(clz.newInstance(), args);
				}
				animal.soStuff();
				return obj;
			}
		};

		// 当前加载器
		ClassLoader cl = getClass().getClassLoader();
		Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz.getInterfaces(), handler);
		proxy.load();
	}
}
```

`注意事例中的doStuff方法，一个装饰类型必然是抽象构建的子类型，必须实现doStuf，此处的doStuff委托给了动态代理执行，并且在动态代理的控制器Handler中设置了决定装饰方式和行为的条件。`

​	`调用如下`

```java
public static void main(String[] args) {

	// 定义Jetty这只老鼠
	Animal jetty = new Rat();

	// 为Jetty增加飞行能力
	jetty = new DecorateAnimal(jetty, FlyFeature.class);

	// 为Jetty增加挖掘能力
	jetty = new DecorateAnimal(jetty, DigFeature.class);

	//
	jetty.soStuff();
}
```

`这是一个通用的装饰模式，只需要定义被装饰的类及装饰类即可，装饰行为由动态代理执行，实现了对装饰和被装饰类的完全解耦，提高了系统扩展性`





### 建议108 反射让模版方法模式更强大





### 建议109 不需要太多关注反射效率

​	反射的效率相对于正常代码执行确实低很多(相差15倍)。但是它是一个非常有效的运行期工具类。

​	一般情况下反射并不是性能的终极杀手，而代码结构混乱，可读性差则可能会埋下性能隐患。



## 第8章 异常



### 建议110 提倡异常封装

​	java API 提供的异常都是比较低级的，只是开发人员能看懂，这就需要对异常进行封装了。异常封装有3方面优点：

```shell
# 1 提高系统的友好性
# 2 提高系统的可维护性
# 3 解决Java异常机制自身的缺陷
```





### 建议111 采用异常链传递异常





### 建议112 受检异常尽可能转化为非受检异常





### 建议113 不要在finally块中处理返回值



`在finally代码块中加入return语句，会导致2个问题`

```shell
# 1 覆盖了try代码块中的return 返回值
# 2 屏蔽异常
```



```java
public class Client113 {

	public static void main(String[] args) throws Exception {
		System.out.println(doStuff(-1));
		System.out.println(doStuff(100));
		System.out.println(val());
		System.out.println(modifyPserson().getName());
	}

	private static int doStuff(int i) throws Exception {

		try {
			if (i < 0) {
				throw new DataFormatException("数据格式错误");
			} else {
				return i;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return -1;
		}

	}

	/**
	 * 该方法返回值永远是1。
	 * 因为finally执行完毕后该方法已经有返回值了，后续代码块就不再
	 * 执行
	 * @return
	 */
	private static int val() {
		int a = 1;
		try {
			return a;
		} catch (Exception e) {
		} finally {
			a = -1;
		}
		return 0;
	}

	/**
	 * 此方法返回值永远都是“finally”，
	 * 因为Person是一个引用对象，在try代码块中的返回值是Person对象的地址，finally中再修改当然就是 finally
	 * @return
	 */
	public static Pserson modifyPserson() {
		Pserson p = new Pserson();
		p.setName("张三");
		try {
			return p;
		} catch (Exception e) {
		} finally {
			p.setName("finally");
		}

		p.setName("finally after");
		return p;
	}

	class Person {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
		}

	}
}
```





### 建议114 不要在构造函数中抛出异常



`java的异常机制有3种`

##### 1 error类以及子类

```shell
# error类以及子类表示的错误。它是不需要程序员处理也不能处理的异
# 常，比如 VirtualMachineError虚拟机错误，ThreadDeath线程僵
# 死等

```

##### 2 RuntimeException

```shell
# RuntimeException类以及子类表示是非受检异常，是系统可能抛出
# 的异常，程序员可以处理，也可以不处理，例如空指针异常

```

##### Exception

```shell
# Exception以及子类(不包括非受检异常)表示的是受检异常，这是必须处理的，否则通不过编译。例如数据库访问异常SQLException
```



构造函数抛出以上3种异常

```shell
# 1 构造函数抛出错误是程序员无法处理的
# 2 构造函数不应该抛出非受检异常
# 3 构造函数尽可能不要抛出受检异常
```



### 建议115 使用Throwable获得栈信息





### 建议116 异常只为异常服务



### 建议117 多使用异常，把性能问题放一边



## 第9章 多线程和并发



### 建议 118 不推荐覆写start方法



```java
public synchronized void start() {
	 //判断线程状态，必须是为启动状态
	if (threadStatus != 0)
		throw new IllegalThreadStateException();
	 //加入线程组中
	group.add(this);

	boolean started = false;
	try {
        //分配栈内存，启动线程，运行run方法
		start0();
		started = true;
	} finally {
		try {
            
			if (!started) {
				group.threadStartFailed(this);
			}
		} catch (Throwable ignore) {
		 
		}
	}
}
//本地方法
private native void start0();
//此处关键方法是 本地start(),它实现了启动线程、申请栈内存、
//运行run方法、修改线程状态等职责，线程管理和栈内存管理都是
//由JVM负责，如果覆盖了start方法，也就是撤销了线程管理和栈内
//存管理的能力。

```



### 建议119 启动线程前stop方法是不可靠的



```shell
# stop方法的目的并不是停止一个线程，而是设置线程为不可用状态
#
#Thread类stop方法会根据线程状态来判断是终结线程还是设置为不可
#运行状态，对于未启动的线程(线程状态为new)来说，会设置其标志位
#为不可启动，而其他的状态则是停止。
```





### 建议120 不要使用stop方法停止线程



`线程启动完毕后，Java提供的终止方法只有一个stop`，但是最好不要用这个。



```xml
<!--
1 stop方法是过时的。
 
2 stop方法会导致代码逻辑不完整

3 stop方法会破坏原子逻辑
-->
```





### 建议121 线程优先级只使用3个等级



`线程优先级就决定了线程获得CPU运行的机会，优先级越高获得机会越大，java的线程优先级有10个级别(也可以说是11个级别，级别为0的线程是JVM的，应用程序不能设置该级别)`

```xml
<!--
1)线程并不严格遵照线程优先级别来执行
2)优先级差别越大，运行机会差别越明显

-->
```



```java
public class Thread implements Runnable {
    /**
     * 最低优先级
     */
    public final static int MIN_PRIORITY = 1;

   /**
     * 默认优先级
     */
    public final static int NORM_PRIORITY = 5;

    /**
     * 最高优先级
     */
    public final static int MAX_PRIORITY = 10;

}
```



### 建议122 使用线程异常处理器提高系统可靠性



```java
public class TcpServer implements Runnable {

	// 创建后立即运行
	public TcpServer() {

		Thread thread = new Thread(this);
		thread.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
		thread.start();
	}

	// 异常处理器
	private static class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// 记录线程异常信息
			System.out.println("线程" + t.getName() + "出现异常，自行重启");
			e.printStackTrace();
			// 重启线程，保证业务不中断
			new TcpServer();
		}

	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("系统组成运行");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 抛出异常
			throw new RuntimeException("淡泊明志，宁静致远");
		}
	}
}
```

```xml
<!--
系统组成运行
线程Thread-0出现异常，自行重启
java.lang.RuntimeException: 淡泊明志，宁静致远
	at com.zhuziym.char09.TcpServer.run(TcpServer.java:45)
	at java.lang.Thread.run(Thread.java:744)
系统组成运行java.lang.RuntimeException: 淡泊明志，宁静致远
	at com.zhuziym.char09.TcpServer.run(TcpServer.java:45)
	at java.lang.Thread.run(Thread.java:744)

线程Thread-1出现异常，自行重启
系统组成运行java.lang.RuntimeException: 淡泊明志，宁静致远
线程Thread-2出现异常，自行重启

-->
```

`java1.5之后在Thread增加setUncaughtExceptionHandler`方法，实现了线程异常的捕获和处理。

​	在使用是需要注意以下3方面：

```xml
<!--
1)共享资源锁定
	如果线程异常产生的原因是资源被锁定，自动重启只会增加系统负
担，无法提供不间断服务。
2) 脏数据引起系统逻辑混乱
3) 内存溢出
	如果异常出现了，但是由该线程创建的对象并不会马上回收，如果重
新启动线程，在创建一批新对象，可能会引起内存泄露问题。
-->
```





### 建议123 volatile不能保证数据同步

```java
public class UnsafeThread implements Runnable {
	// 共享资源
	private volatile int count = 0;
	@Override
	public void run() {
		for (int i = 0; i < 1_000; i++) {
			Math.hypot(Math.pow(92456789, i), Math.cos(i));
		}
		count++;
	}

	public int getCount() {
		return count;
	}

}

```



```java
public static void main(String[] args) throws InterruptedException {
	// 最大循环次数
	int value = 1000;

	// 循环次数，防止出现无线循环
	int loops = 0;
	// 主线程组，用于估计活动线程数
	ThreadGroup tg = Thread.currentThread().getThreadGroup();

	while (loops++ < value) {
		UnsafeThread ut = new UnsafeThread();
		for (int i = 0; i < value; i++) {
			new Thread(ut).start();
		}
		// 等待15毫秒，等待活动线程数量为1
		do {
			Thread.sleep(15);
		} while (tg.activeCount() != 1);

		if (ut.getCount() != value) {
			// 出现线程不安全的情况
			System.out.println("循环到第" + loops + " 次，出现线程不安全");
			System.out.println("此时count = " + ut.getCount());
			System.exit(0);
		}
	}
}
```

`volatile不能保证数据时同步的，只能保证线程获得最新值`



### 建议124 异步运算考虑使用Callable接口

```xml
<!--
	多线程2种方式,存在的缺点，run方法没有返回值，不能抛出异常。
	java1.5开始，引入了Callable 接口，类似于Runable接口，实现
它就可以实现多线程任务。(具有返回值，可以抛出异常)
-->
```


```java
public class TaxCalculator implements Callable<Integer> {
	// 本金
	private int seedMoney;

	public TaxCalculator(int seedMoney) {

		this.seedMoney = seedMoney;
	}

	@Override
	public Integer call() throws Exception {

		// 模拟复杂运算，运行一次10秒
		TimeUnit.MILLISECONDS.sleep(10_000);
		return seedMoney / 10;
	}
}

```

`实现Callable接口的类，只是表明它是一个可调用的任务，并不表示它具有多线程运算能力，还需要执行器来执行`

```java
public static void main(String[] args) throws Exception {
	// 生成一个线程的异步执行器
	ExecutorService es = Executors.newSingleThreadExecutor();
	// 线程执行后的期望值
	Future<Integer> future = es.submit(new TaxCalculator(100));

	while (!future.isDone()) {
		// 还没完成等待200毫秒
		TimeUnit.MILLISECONDS.sleep(200);
		// 输出进度条
		System.out.print("#");
	}
	System.out.println("\n计算完成，结果是" + future.get());
	es.shutdown();

}

```

`异步同步的好处`

`尽可能地多占用系统资源，提供快速运算`

`可以监控线程执行的情况，比如是否执行完毕、是否有返回值、时候有异常`



### 建议125 优先选择线程池



```java
public static void main(String[] args) {
	// 2个线程的线程池
	ExecutorService ex = Executors.newFixedThreadPool(2);
	// 多次执行线程体
	for (int i = 0; i < 6; i++) {
		ex.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
	}
	// 关闭执行器
	ex.shutdown();
}
```

`线程池涉及的3个名词`

```xml
<!--
	1)工作线程(worker)
	线程池中的线程，只有2个状态：可运行状态和等待状态，在没有任务
时他们处于等待状态，运行时可以循环地执行任务
	
	2)任务接口(Task)
	这是每个任务必须实现的接口，以供工作线程调度器调度，它规定了
任务的入口、任务执行完的场景处理、任务的执行状态等。
	
	3)任务队列(wok queue)
	也叫做工作队列，用于存放等待处理的任务
-->
```



```java
 public static ExecutorService newFixedThreadPool(int nThreads) {
    //生成一个最大为nThreads 的线程执行器
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
 }
//此处使用了 LinkedBlockingQueue 作为任务队列管理器，所有等待处
//理的任务都会放在该队列中，次队列是一个阻塞式的单端队列。线程池建
//立好，线程运行是在submit 第一次提交任务时建立的。
```



```java


```



### 建议126 适时选择不同的线程池来实现

`Java的线程池从最根本来说只有2个：ThreadPoolExecutor类和ScheduledThreadPoolExecutor类，java为了简化并行计算，还提供了一个Executors的静态类，可以直接生成多种不同的线程池执行器，但归根到底还是ThreadPoolExecutor类和ScheduledThreadPoolExecutor类。`

##### ThreadPoolExecutor 构造函数

```java
public class ThreadPoolExecutor extends AbstractExecutorService {
ultHandler);
        public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
            //检验输入条件
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
       	//检验运行环境
            if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }

    
}

```

`上述构造函数参数`

```xml
<!--
	corePoolSize:最小线程数(线程数量是逐步达到corePoolSize值
的，例如，例如corePoolSize值是10，而任务只有5，线程池中最多有5个
启动的线程，而不是一次性启动10个线程)


maximumPoolSize：最大线程数(线程池中最大容纳的线程数量，如果超
出，则使用RejectedExecutionHandler拒绝策略处理)

	keepAliveTime:线程最大生命周期
	
	unit：时间单位
	
	workQueue：任务队列(当线程池中的线程出于运行状态，而此时任
务数量继续增加，则需要一个容器来容纳这些任务，这就是任务队列)

	threadFactory：线程工厂(定义如何启动一个线程，可以设置线程
名称，并且可以确认是否是后台线程等)

	handler：拒绝任务处理器
-->
```

`Executors提供的几个创建线程池的方法`

- newSingleThreadExecutor:单线程池

```xml
<!--
	

	只有一个线程在运行，该线程永不过时，而且由于一个线程，当有多
个任务需要处理时，会将他们放到一个无阻塞队列中逐个处理。

	

-->
```

```java
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

//使用如下
private static void single() throws InterruptedException, ExecutionException {
	ExecutorService es = Executors.newSingleThreadExecutor();

	Future<String> future = es.submit(new Callable<String>() {

		@Override
		public String call() throws Exception {
			return "thread";
		}
	});
	//获得任务执行返回值
	System.out.println(future.get());
	//关闭执行器
	es.shutdown();
}
```



- newCachedThreadPool：缓存功能的线程池

```java
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
//线程队列使用了同步阻塞队列，这也就是向队列中加入一个元素，即可
//唤醒一个线程来处理，这种队列没有队列深度的概念
```



- newFixedThreadPool：固定线程数量的线程池

```java
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
//	在初始化时决定了线程最大数量，若任务添加的能力超出了线程处理
//能力，则建立阻塞队列容纳多余的任务。
//	如果任务增长速度快，超过了LinkedBlockingQueue最大容量，则按
//照ThreadPoolExecutor默认的拒绝策略(直接丢弃)来处理
```



### 建议127 Lock与synchronized是不一样的

`Lock类和synchronized关键字在代码块的并发和内存上是语义是一样的，都是保持代码块同时只有一个线程具有执行权。但是一个任务提交给多个线程运行，lock类和内部锁synchronized有不同`



定义一个任务

```java
public class Task {
	public void doSomething() {
		try {
			// 等待 2秒 ，此时的线程转为WAITING状态
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("线程名称：" + Thread.currentThread().getName());
		// 运行时间戳
		sbBuffer.append("，执行时间：" + Calendar.getInstance().get(13) + "s");
		System.out.println(sbBuffer);
	}
}
//模拟了一个执行时间比较长的计算，在使用sleep方法时线程的状态会从运行状态转变为等待状态。
```

显示锁任务

```java
public class TaskWithLock extends Task implements Runnable {

	// 声明显示锁
	private final Lock lock = new ReentrantLock();

	@Override
	public void run() {

		try {
			// 开始锁定
			lock.lock();
			doSomething();
		} finally {
			lock.unlock();
		}
	}
}
//需要说明的是，显示锁的锁定和释放必须在一个try ....finally块
//中，这是为了确保即使运行期异常也能正常释放锁，保证其他线程能顺
//利执行
```

内部锁任务

```java
public class TaskWithSync extends Task implements Runnable {
	@Override
	public void run() {
		// 内部锁
		synchronized ("A") {
			doSomething();
		}
	}
}

```

模拟场景运行上面

```java
public class Client127 {
	public static void main(String[] args) throws Exception {
		runTasks(TaskWithLock.class);
		runTasks(TaskWithSync.class);

	}

	static void runTasks(Class<? extends Runnable> clz) throws Exception {
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("开始执行" + clz.getSimpleName() + " 任务名称");
		// 启动三个线程
		for (int i = 0; i < 3; i++) {
			es.submit(clz.newInstance());
		}
		// 等待足够长的时间 然后关闭执行器
		TimeUnit.SECONDS.sleep(10);
		System.out.println("***" + clz.getSimpleName() + "任务执行完毕***\n");

		es.shutdown();

	}
}
```





```xml
<!--
执行结果

开始执行TaskWithLock 任务名称
线程名称：pool-1-thread-2，执行时间：14s
线程名称：pool-1-thread-1，执行时间：14s
线程名称：pool-1-thread-3，执行时间：14s
***TaskWithLock任务执行完毕***

开始执行TaskWithSync 任务名称
线程名称：pool-2-thread-1，执行时间：24s
线程名称：pool-2-thread-3，执行时间：26s
线程名称：pool-2-thread-2，执行时间：28s
***TaskWithSync任务执行完毕***
-->




<!--
	显示锁是同时运行的。显然在pool-1-thread-2线程在运行sleep
时，其他两个线程也运行到这里，一起等待，然后一起输出，这不符合线
程互斥概念

	内部锁，按照事我们预期的结果。


	问题：Lock锁为什么不出现互斥情况？
	对于同步资源来说(示例中的代码块)，显示锁是对象级别的锁，而
内部锁类级别的锁，(Lock是跟随对象的，synchronized锁是跟随类
的)。简单的说Lock定义为所有多线程的私有属性是起不到资源互斥作用
的，除非Lock定义为所有线程共享变量。下面代码是一个lock锁资源的
代码

-->
```

一个lock锁资源的代码

```java
	private static void lockTask() {
		// 多个线程共享
		final Lock lock = new ReentrantLock();
		// 启动3个线程
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						lock.lock();
						Thread.sleep(2000);
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}).start();
		}
	}
//结果
//Thread-1
//Thread-2
//Thread-0
实现了一个线程在执行，其他线程处于等待状态


```



#### 显示锁和内部锁的不同(4点不同)

##### 1：Lock支持更细粒度的锁控制



```xml
<!--
	假设读写锁分离，写操作时不允许读写操作存在，儿读操作时读写可
以并发执行。这一点内部锁难以实现
-->
```

```java
public class Foo {
	// 可重入的读写锁
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	// 读锁
	private final Lock rLock = rwl.readLock();

	// 写锁
	private final Lock wLock = rwl.writeLock();

	// 多操作，并发执行
	public void read() {
		try {
			rLock.lock();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rLock.unlock();
		}
	}

	// 写操作，同时只允许一个写操作
	public void write(Object obj) {
		try {
			wLock.lock();
			Thread.sleep(2000);
			System.out.println("Foo.write()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			wLock.unlock();
		}

	}
}
```

```xml
<!--
	读写锁允许同时有多个读操作但只允许有一个写操作，也就是当有一
个写线程在执行是，所有的读写线程都会阻塞，直到写线程释放锁资源为
止，而读锁可以有多个线程同时执行。

-->
```



##### 2：Lock是无阻塞锁，synchronized是阻塞锁

```xml
<!--
	当线程A持有锁时，线程B也期望获得锁，此时，如果程序中使用的是
显示锁，则B线程为等待状态，若使用的是内部锁则为阻塞状态。
-->
```



##### 3：Lock可以公平锁，synchronized只能是非公平锁

```xml
<!--
	当一个线程A持有锁，而线程B、C出于阻塞或者等待状态时，若线程A
释放锁，JVM从线程B、C中随机选择一个线程持有锁并使其获得执行权，这
就是非公平锁。若JVM选择了等待时间最长的一个线程持有锁，则为公平锁
。
	显示锁默认是非公平锁，但是可以在构造函数加入参数true来申明
为公平锁。
-->

```



##### 4： Lock是代码级的，synchronized是JVM级的





### 建议128 预防线程死锁





#### 达到死锁的4个条件

```xml
<!--
	1）互斥：一个资源每次只能被一个线程使用。
	2）资源独占：一个线程因请求资源阻塞时，对已获得的资源保存不
放
	3）不剥夺：线程以获得的 资源在未使用完之前，不能进行剥夺
	4）循环等待条件：若干线程之间形成一种头尾相接的循环等待资源
关系
-->

```





### 建议129 适当设置阻塞队列长度

`阻塞队列BlockingQueue扩展了Queue、Collection接口,对元素的插入和提取使用了阻塞处理，Collection实现了长度自行管理`

```java
public static void main(String[] args) {

	BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);

	for (int i = 0; i < 10; i++) {
		blockingQueue.add("");
		// Exception in thread "main" java.lang.IllegalStateException: Queue
		// full
	}

}
//BlockingQueue不能自动扩展长度
```

`阻塞队列和非阻塞队列一个重要区别：阻塞队列容量是固定的，非阻塞队列是变长的`





### 建议130 使用CountDownLatch协调子线程





### 建议131 CyclicBarrier让多线程齐步走





## 第10章 性能和效率

### 建议132 提升Java性能的基本方法



- 不要在循环条件中计算
- 尽可能把变量、方法声明为final static 类型
- 缩小变量的作用范围(目的是加速GC回收)
- 频繁字符串操作使用stringBuilder或StringBuffer
- 使用非线性检索
- 不要建立冗余对象



### 建议133 若非必要，不要克隆对象

`clone方式只是一个冷僻的生成对象方式，并非主流，主要用于构造函数复杂，对象属性比较多，通过new关键字创建一个对象比较耗时的时候`



### 建议134 推荐使用“望闻问切”的方式诊断性能



### 建议135 必须定义性能衡量标准





### 建议136 强打出头鸟——解决首要系统性能问题



### 建议137 调整JVM参数以提升性能



### 建议138 性能是个大“咕咚”





## 第11章 开源世界

### 建议139 大胆采用开源工具





### 建议140 推荐使用Guava扩展工具包



- Collections（主要包括：不可变集合、多值Map、Table表和集合工具类）

```java
public static void main(String[] args) {
	// 不可变集合
	ImmutableList<String> list = ImmutableList.of("A", "B", "C");

	// 不可变Map
	ImmutableMap<Integer, String> map = ImmutableMap.of(1, "A", 2, "B", 3, "C");

	// 多值Map
	ArrayListMultimap<Object, Object> arrayListMultimap = ArrayListMultimap.create();

	arrayListMultimap.put("name", "grq");
	arrayListMultimap.put("name", "lifeng");
	System.out.println(arrayListMultimap);

	// table
	Table<Double, Double, String> g = HashBasedTable.create();

	g.put(31.23, 121.38, "人民广场");
	System.out.println(g);

	// 类似于数据库表的存储方式
	Table<Integer, Integer, String> user = HashBasedTable.create();
	user.put(1, 1, "grq");
	user.put(1, 2, "sunjie");
	String string = user.get(1, 2);
	System.out.println(string);

	// Map操作
	HashMap<String, Integer> useMap = new HashMap();
	useMap.put("grq", 25);
	useMap.put("sunjie", 24);
	useMap.put("dou", 22);

	// 所有年龄大于22的人
	Predicate valuePredicate;
	Map<String, Integer> filterValues = Maps.filterValues(useMap, new Predicate<Integer>() {

		@Override
		public boolean apply(Integer input) {
			return input > 22;
		}
	});

	System.out.println(filterValues);

	// 基本类型工具
	/**
	 * 基本类型工具是以基本类型+s的方式命名的，只是针对基本类型 ，不是针对包装类型
	 */

	int[] insts ={1,23,5,5,88,21,43}; 
	//最大值
	System.out.println(Ints.max(insts));
}
```



### 建议141 Apache扩展包

`Apache Commons通用扩展包基本上都会使用，一般情况下lang包作为JDK的基础语言扩展包，collections作用是集合扩展`

```java
public static void main(String[] args) {
	// 判断是否为空
	StringUtils.isEmpty("");
	// 是否是数字
	StringUtils.isNumeric("12");
	// 统计子字符串出现的次数
	StringUtils.countMatches("abcd", "a");
	// 转义XML标示
	StringEscapeUtils.escapeXml("<project xmlns=http://maven.apache.org/POM/4.0.0 xmlns:xsi=http://www.w3.org/2001/XMLSchema-instance xsi:schemaLocation");
	// 随机生成长度为6的ASCII字符串
	String randomAscii = RandomStringUtils.randomAscii(6);
	WordUtils.capitalize("abc bcd");

	// Object
	Person person = new Person();
	person.setAge(12);
	person.setName("grq");
	System.out.println(person);

}

```

```java
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
		//姓名相同 认为两个对象相同
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(name, p.name).isEquals();
	}
}
```



### 建议142 推荐使用Joda日期时间扩展包



```xml
<!--

	需要注意的是，DateTime是一个不可变类型，与String非常类似，
即使是plusXXX、minusXXX等操作，DateTime对象仍然不会变，只是新生
成一个DateTime对象。
	但是，Joda也提供了一个可变类型的日期对象：MutableDateTime
类，这样，日期操作更加方便了。
-->
```



### 建议143 可以选择多种Collections扩展

`下面简单介绍3个有个性的Collections扩展工具包`

- FastUtil

`fastutil主要提供2种功能：一种是限定键值类型的Map、List、Set，另一种是大容量的集合(一个Coolection最大容量是Integer的最大值，fastutil提供的Big系列的集合，最大容量是Long的最大值，但是在使用时需要考虑内存溢出问题，调节JAVA的mx参数)`

```java
private static void fastUtil() {

	// 明确键类型的Map
	Int2ObjectMap<String> map = new Int2ObjectOpenHashMap<String>();
	map.put(100, "grq");
	// java.lang.OutOfMemoryError
	BigList<String> bigList = new ObjectBigArrayBigList<String>(1L + Integer.MAX_VALUE);

	// 基本类型的集合，不再使用Intreger包装类型
	IntArrayList intArrayList = new IntArrayList();
}

```



- trove

`trove提供了一个快速，高效，低内存消耗的Collection集合，并且还提供了过滤和拦截功能，同时还提供了基本类型的集合`



```java
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
```

`trove最大优势在高性能上，在一般的增加、修改、删除操作时，trove响应时间比JDK提供的集合少一个数量级，比fastutil也高很多。因此，高性能项目要考虑trove`



- lambdaj

`是一个纯净的集合操作工具，不提供任何集合扩展，只是提供集合操作，比如查询、过滤、统一初始化等，特别是他的查询，非常类似于DBRMS上的SQL语句，也提供求和，求平均值等方法`

```java
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

```



maven

```xml
<!-- collection扩展包 -->
<dependency>
	<groupId>it.unimi.dsi</groupId>
	<artifactId>fastutil</artifactId>
	<version>8.1.1</version>
</dependency>
<dependency>
	<groupId>net.sf.trove4j</groupId>
	<artifactId>trove4j</artifactId>
	<version>3.0.3</version>
</dependency>
<dependency>
	<groupId>com.googlecode.lambdaj</groupId>
	<artifactId>lambdaj</artifactId>
	<version>2.3.3</version>
</dependency>
```

