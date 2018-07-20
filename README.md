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
<<<<<<< HEAD
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

```
