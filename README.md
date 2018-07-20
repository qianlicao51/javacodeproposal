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





