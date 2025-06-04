Graphical User Interface -- GUI

Command Line Interface -- CLI

get to know command line on mac os



什么是垃圾回收？

# install java/jdk/jre and environment of java

https://zhuanlan.zhihu.com/p/345765547



# Environment of Java

JDK -- Java Development Kit

JRE -- Java Runtime Environment (JRE include JVM(Java Virtual Machine) and other 核心类库)

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/Bildschirmfoto 2022-06-14 um 14.00.44.png" alt="Bildschirmfoto 2022-06-14 um 14.00.44" style="zoom:50%;" />

JDK = JRE + 开发工具集

JRE = JVM + Java SE标准类库等

# 1 Overview Structure of Java

![image-20220615120054504](/Users/hurjiang/Library/Application Support/typora-user-images/image-20220615120054504.png)

字节码

java严格区分大小写

java文件编译之后生成class文件，也就是字节码文件，然后再运行字节码文件

## Comment

### one line comment  //

### lines comment	/* */

多行注释不能嵌套使用

### document comment

document comment is speical comment and only in Java

/**  */

`javadoc -d (docname)myHello -author -version HelloWorld.java(name)`

after this command we will have a new document which name is myHello and in this document will have many html documents, one is index.html, open it

注释内容可以被JDK提供的工具 javadoc 解析，生成一套以网页文件形式体现的该程序的说明文档

Java API 文档

API: Application Programming Interface

Dash

## HelloWorld

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello, World!");
    }
}
```

1. 编写-编译-运行
   - 编写：我们将编写的java代码保存在以“.java”结尾的源文件中
   - 编译：使用javac.exe命令编译我们的java源文件。格式为：javac 源文件名.java
   - 运行：使用java.exe命令解释运行我们的字节码文件。格式为：java 类名
2. 在一个java源文件中可以声明多个class
   - 但是只能有一个类声明为public的
   - public的类的类名必须与源文件名相同
3. 程序的入口是main()方法，格式是固定的
   - "args" comes from "arguments参数"

4. 输出语句

   `System.out.println();`先输出后换行

   `System.out.print();`不换行

5. 编译的过程：编译以后，会生成一个或多个字节码文件。字节码文件的文件名与java源文件中的类名相同

## Quiz Day01

1. JDK，JRE，JVM三者之间的关系，以及JDK，JRE包含的主要结构有哪些

​		JDK = JRE + Java的开发工具(javac.exe,  java.exe, javadoc.exe)

​		JRE = JVM + Java的核心类库

2. 为什么要配置path环境变量？如何配置？
   - 希望在任意路径下都能使用java命令，mac下应该不需要另外配

3. 常用的几个命令行操作有哪些

   这里win和mac是不一样的

   cd, cd ...

4. 创建如下的类，使得运行的话可以输出

   ```java
   public class ChairMan{
     public static void main(String[] args){
       System.out.println("name:Hur");
       System.out.println();
       System.out.println("gender:male");
       System.out.print("address:Leipzig");
     }
   }
   ```

5. 编译和运行上述代码的指令

   `javac ChairMan.java`

   `java ChairMan`

# 2 Syntax of Java

## reserved word

## Identifier

各种变量、方法、类等要素的名字

### Rule of naming

英文字母、数字、_ 或 $

数字不能开头

不能是关键字和保留字，但是可以包含

没有空格

有大小写区别

### Convention of naming

- name of package：xxxyyyzzz
- name of class：XxxYyyZzz
- name of variable：xxxYyyZzz
- name of constant：XXX_YYY_ZZZ
- !!! attention
  - 见名知意
  - java 采用unicode字符集，因此标识符也可以用汉字声明，但是不要使用

## Data Type

### general

#### primitive, reference, wrapper

- primitive
  - 整数类型：byte，short，int，long
  - 浮点类型：float，double
  - （整型和浮点型都属于数值型）
  - 字符型 char
  - 布尔型 boolean
- reference
  - class（字符串属于类）
  - interface
  - array

- Wrapper

#### member and local

- 成员变量(member variable)和局部变量(local variable)
  - member variable
    - belong to class
    - modified by `static` : to class
    - else: to instance
  - local variable

``` java
public class VariableExample{
  // member variable, which store in heap memory
  private String name;
  private int age;
  
  // local variable in method
  public void method() {
    int num1 = 10;	// exist in stack memory
    String str = "Hello World"; // exist in stack memory
    System.out.println(num1);
    System.out.println(str);
  }
  
  // local variable in method which has parameter
  public void method2(int num2){
    int sum = num2 + 10; // exist in stack memory
    System.out.println(sum);
  }
  
  // local variable in constructor method
  public VariableExample(String name, int age){
    this.name = name; // assign value to the member variable
    this.age = age; // assign value to the member variable
    int num3 = 20; // local variable exist in stack memory
    String str2 = "Hello" + this.name + "!"; // local variable exist in stack memory
    System.out.println(num3);
    System.out.println(str2);
  }
}
```

### primitive data type

#### integer

byte, short, int, long

<img src="/Users/hurjiang/Desktop/Bildschirmfoto 2022-06-15 um 15.39.40.png" alt="Bildschirmfoto 2022-06-15 um 15.39.40" style="zoom:50%;" />

通常定义整型变量用的是int型

对long型定义的时候赋值结尾要加L或l：`longl1 = 333343L` 

默认的常数类型为 int

#### diligence decimal/point numbers

float 单精度

double 双精度

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220615154806373.png" alt="image-20220615154806373" style="zoom:50%;" />

Q: 为什么float和int同样是占4byte，但是float的表示范围比int大这么多，甚至比long还大

A: 因为float的组成是前面一部分表示数字，后面一部分表示10的几次幂

float类型定义是，结尾要以f或F `float f1 = 12.4F`

通常定义浮点型用double

#### boolean

true or false

常出现在条件判断，循环中出现

#### char

1 character = 2 bytes

定义char型变量，通常使用一对 '', 内部只能写一个字符，各种语言都可以

1. 可以表示转义字符：\n 换行符, \t tap键

   Q：若是要想输出\n怎么办？

   A：前面再加一个\

2. 也可以直接使用unicode值来表示字符型常量

#### String

String和其它类型用 "+" 运算时，是指连接

Q：要求输出 "* *"这样的效果

`System.out.println("*   *"); // *   *`

`System.out.println('*' + '\t' + '*'); // doesn't work out`

`System.out.println('*' + "\t" + '*'); // * *`

`System.out.println('*' + '\t' + "*"); // a number + *`

`System.out.println('*' + ('\t' + "*")); // * *`

Q：请问下述语句可以编译通过吗

`String str1 = 123;`	 no

`String  str1 = 123 + ""; `	yes

Q：String类可以逆向转换为其它类型吗？如何转换呢？

可以，但是不是现在掌握的

`int num1 = str1;`

`int num1 = (int)str1;`

以上两种办法都是不行的，会编译失败

String的运算和其它几种基本数据类型的运算是不同的，可以理解为完全不一样的范围

String和几种基本数据类型只能用"+"表示连接

### 基本数据类型之间的运算规则

#### 自动类型提升

byte, char, short --> int --> long --> float --> double

==当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果会自动提升为容量大的数据类型==

==*这里所谓的容量大小是指这个数据类型表示数的范围的大小，并不是指占用的空间内存大小!==

特别的：byte, char, short 这三种类型的变量做运算时，结果为int型

#### 强制类型转换

自动类型提升的逆运算

强转符: ( )

强制类型转换可能导致精度损失

Q：请问以下的强制转换会输出什么结果？

```java
public class TypeVariableTransfer{
  public static void main(String[] args){
		int i2 = 128;
    byte b = (byte)i2;
    System.out.println(b);
  }
}

--> -128 // why?
```

二进制的128和-128为：

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220616125430235.png" alt="image-20220616125430235" style="zoom:50%;" />

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220616125240367.png" alt="image-20220616125240367" style="zoom:50%;" />

int 128, 32 位 转为 byte

1 个byte是8位

在计算机的底层都是存储补码，正数的二进制原码、反码和补码都是相同的



#### 一些编码情况

`long l = 12323` 若是赋值时没有在结尾加上L，那么这个值会被默认为int型

`long l1 = 123824838483843` 当这个值过大的时候，那就会报错



整型**常量**默认为int型

浮点型**常量**默认为double型

### Quiz Day02

1. 标识符的命名规则

   英文字母，数字，$ 和 _

   数字不能开头

   大小写要区分

   不能有空格

   不能使用关键字和保留字，但是可以包含

2. 标识符的命名规范

   包名：xxxyyyzzz

   类名和接口名：XxxYyyZzz

   变量名和方法名：xxxYyyZzz

   常量名：XXX_YYY_ZZZ

3. java变量按照数据类型怎么分？哪8种基本数据类型，并指出它们各自的内存空间大小

   基本数据类型和引用数据类型

   byte(1个字节，8个位), short(2字节), int(4字节), long(8字节)

   float(4字节), double(8字节)

   char(1个字符等于两个字节)

   boolean

   引用数据类型：类，接口和数组

4. 自动类型提升的运算的规则

   小容量的数据类型转为大容量的数据类型

   byte, short, char --> int --> long --> float --> double

5. 强制类型转换的使用规则和强转可能出现的问题

​		int i = 3

​		short = (short) i

​		会出现精度损失的问题

### wrapper

对八种基本数据类型定义的相应的引用类型，称为包装类

 希望让基本数据类型也具有类的特征

包装类使基本数据类型的变量具有类的特征

| Primitive Data Type | Wrapper Class |
| ------------------- | ------------- |
| byte                | Byte          |
| short               | Short         |
| int                 | Integer       |
| long                | Long          |
| float               | Float         |
| double              | Double        |
| boolean             | Boolean       |
| char                | Character     |

Other than Boolean and Character are numerics, they all have same super class: Number

#### 重点：基本数据类型、包装类与String类三者之间的转换

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220714161611964.png" alt="image-20220714161611964" style="zoom:50%;" />

#### 1.基本数据类型 --> 包装类

```java
package com.hurjiang.wrapper;

import org.junit.Test;

public class WrapperTest {
	
	@Test
	public void test1() {
		
		int num1 = 10;
		
//		System.out.println(num1.toString());
		Integer intnum1 = new Integer(num1); // int -> Integer
		System.out.println(intnum1.toString());	// -> 10
		
		Integer intnum2 = new Integer("123"); // why this works?
		System.out.println(intnum2.toString()); // ->123
		
//		Integer intnum3 = new Integer("123aab");
//		System.out.println(intnum3.toString()); // ->NumberFormatException
		
		Float f1 = new Float(12.3f);
		Float f2 = new Float("12.3");
		System.out.println(f1);	//-> 12.3
		System.out.println(f2);	//-> 12.3
		
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean("true");
		Boolean b3 = new Boolean("true123");
		Boolean b4 = new Boolean("TrUe");
		System.out.println(b1);	//->true
		System.out.println(b2);	//->true
		System.out.println(b3); //->false why? 去看Boolean的源码, 只要和“true”不一样，都是false
		System.out.println(b3); //->true, 源码中写和大小写无关
		
		Order order = new Order();
		System.out.println(order.isMale); //->false, boolean类型的初始值为false
		System.out.println(order.isFemale); //->null, Boolean类的初始值为null，因为是引用数据类型，要么是地址值，要么是null
		
	}
}
class Order{
	
	boolean isMale;
	Boolean isFemale;
}
```

#### 2. wrapper class --> primitive data type

```java
// 包装类 --> 基本数据类型：调用包装类Xxx的xxxValue()
	@Test
	public void test2() {
		Integer intWrapper1 = new Integer(112);
		System.out.println(intWrapper1+1); //为什么这里的值和下面是一样的，而且也可以加减？
		int int1 = intWrapper1.intValue();
		System.out.println(int1+1);
	}
```

#### 3. autoboxing and unboxing

- autoboxing: valueOf(...), e.g. Integer.valueOf(10)
- unboxing: ...Value(), e.g. Integer.intValue()

```java
Integer one = new Integer(10); // manually boxing
int two = one.intValue(); // manually unboxing

Integer one = 10; // autoboxing: Integer.valueOf(10)
in two = one; // auto-unboxing: Integer.intValue()
```

- Quiz

  ```java
  // 1. primitive data type and wrapper class
  int a = 100;
  Integer b = 100; // autoboxing
  System.out.println(a == b); // b unboxing(auto) and compare with a, returns true
  
  // 2. two wrapper classes
  Integer c = 100;
  Integer d = 100;
  System.out.println(c == d); // false, because c and d are objects and they are stored in different "places"
  
  // 3.
  c = 200;
  d = 200;
  System.out.println(c == d); // false
  ```

  - second returns true: IntegerCache (see source code)
  - if number is between -128 and 127, then will use instance in cache directly, not renew a instance, so second is true, but third is false, because it's 200

#### 4. primitive data type, wrapper class <--> String

```java
// primitive data type, wrapper class --> String
	@Test
	public void test4() {
		
		int num1 = 10;
		// 方式一：连接运算
		String str1 = num1 + ""; 
		// 方式二：调用String的valueOf(Xxx xxx)
		float f1 = 12.3f;
		String str2 = String.valueOf(f1);
		System.out.println(str2);
	}
```

```java
// String --> primitive data type, wrapper class：调用包装类中的parseXxx(str)
	@Test
	public void test5() {
		String str1 = "123";
		String str2 = "true";
//		int num1 = (int)str1; // 为什么错？
//		Integer in1 = (Integer)str1; // Integer和String二者之间没有子父类关系
		int num2 = Integer.parseInt(str1);
		boolean b1 = Boolean.parseBoolean(str2);
		System.out.println(num2);
		System.out.println(b1);
	}
```

#### InterviewQuizWrapper

1. 

   ```java
   package com.hurjiang.wrapper;
   
   import org.junit.Test;
   
   public class InterviewQuiz {
   	
   	@Test
   	public void test1() {
   		Object o1 = true ? new Integer(1) : new Double(2.0); //多态，子类-->父类
   		System.out.println(o1); //--> 1.0
   		//编译要求三目运算 : 的左右两边类型相同，所以这里做了自动类型提升
   	}
   	
   	@Test
   	public void test2() {
   		Object o2; 
   		if (true)
   			o2 = new Integer(1); 
   		else
   			o2 = new Double(2.0); 
   		System.out.println(o2);// --> 1
   	}	
   }
   ```

2. 

   ```java
   public void test3() {
   		Integer i = new Integer(1); 
   		Integer j = new Integer(1); 
   		System.out.println(i == j); //false
   		
   		/*
   		 * Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
   		 * 保存了从-128 - 127 范围的整数。
   		 * 如果我们使用自动装箱的方式给Integer赋值，且赋值的范围在-128-127之间，
   		 * 就可以直接使用数组中的元素，不用再去new，从而提高了效率
   		 */
   		
   		Integer m = 1;
   		Integer n = 1; 
   		System.out.println(m == n); //true
   		
   		Integer x = 128; //但是这里128超出了数组存储数据的范围，所以要new
   		Integer y = 128; //同样的，这里也要new
   		System.out.println(x == y); //false
   		}QuizWrapper
   ```

#### WrapperQuiz

利用Vector代替数组处理:从键盘读入学生成绩(以负数代表输入结束)，找出 最高分，并输出学生成绩等级。

-> 提示:数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的 长度。而向量类java.util.Vector可以根据需要动态伸缩。

-> 创建Vector对象:Vector v=new Vector(); 

-> 给向量添加元素:v.addElement(Object obj); //obj必须是对象 

-> 取出向量中的元素:Object obj=v.elementAt(0);

-> 注意第一个元素的下标是0，返回值是Object类型的。

 -> 计算向量的长度:v.size(); 

-> 若与最高分相差10分内:A等;20分内:B等; 30分内:C等;其它:D等

```java
package com.hurjiang.wrapper;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
	
	public static void main(String[] args) {
		
		//1. 实例化Scanner，从键盘读入学生成绩score: Scanner scan = new Scanner(System.in);
		//2. 创建Vector对象 Vector v = new Vector();
		//3. 将score添加到v中，但是score是int型，v是对象，所有需要转换
		//   3.1 自动装箱 或
		//   3.2 Integer intScore = new Integer(score);
		//4. 在添加过程中，找出最大值
		//5. 遍历v，将v中的对象取出，将其转为int，从而与最大值比较，得出学生的等级
		//   5.1 自动拆箱
		//   5.2 ...
		//6. v.size() 得出v的长度
		
		Scanner scan = new Scanner(System.in);
		Vector v = new Vector();
		int maxscore = 0;
		for(;;) {
			System.out.println("Please enter into the score: ");
			int score = scan.nextInt();
			
			if(score < 0) { //循环的结束条件：输入的分数是负数
				break;	
			}
			if(score > 100) { //若是输入大于100的分数呢，就continue
				continue; //when score is bigger than 100, it will not be counted
			}
			//自动装箱
//			v.addElement(score);
			Integer intScore = new Integer(score);
			v.addElement(intScore); //这里体现了Java的什么特性？ 提示: intScore是Object的子类
			
			//find max
			if(score > maxscore) {
				maxscore = score;
			}
		}
		//6.get length of vector
		int vlength = v.size();
		System.out.println("Here are " + vlength + " students in total!");
		//5.遍历
		for(int i = 0; i < vlength; i++) {
			Object obj = v.elementAt(i); //为什么这里取出来的数组中的对象是Object类型呢
			System.out.println(v.elementAt(i) instanceof Integer);
			//若是👆这个语句输出的都是true，那不就证明了取出来的对象就是Integer类吗
			//那既然是Integer类，那为什么不能直接使用类的方法呢？
			Integer intScore = (Integer)obj; //从父到子是强转，从子到父是多态
			int score = intScore.intValue();
			//上面两行为何不能合起来这么写：v.elementAt(i).intValue();
			
			//自动拆箱1
//			int score = intScore;
			//自动拆箱2
//			int score = (int)obj; //先强转，再自动拆箱
			int differ = maxscore - score;
			if(differ < 10) {
				System.out.println("Student" + i + "'s score is " + score + ", which is " +  " A.");
			}else if(differ < 20) {
				System.out.println("Student" + i + "'s score is " + score + ", which is " +  " B.");
			}else if(differ < 30) {
				System.out.println("Student" + i + "'s score is " + score + ", which is " +  " C.");
			}else {
				System.out.println("Student" + i + "'s score is " + score + ", which is " +  " D.");
			}
			
		}
		System.out.println("Max of score is " + maxscore + ".");
	}
}
```

### Comparasion between primitive and wrapper

- storage (where are they stored?)
- default value
  - primitive: not `null`, something else, for example 0, -1 ...
  - wrapper: `null`
- how to compare value
  - primitive: `==`
  - wrapper: `equals()`, because `==` compare the address where the object saved

## Modifier

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220629182415595.png" alt="image-20220629182415595" style="zoom:50%;" />

- `static`: when it modifies variable

  ``` java
  public class StaticVariableExample{
    public static int staticVar == 0;
  }
  ```

  - we can get this static variable of class through the name of class `StaticVariableExample.staticVar` 
  - static variable will be shared with all instances of this class, no matter how many instances of this class, it means static variable will only be allocated memory once

## 运算符

### 算数运算符

Q: int num1 = 12, int num2 = 5, how can num1/num2 get 2.4 ?

`int result1 = num1 / num2;` --> 2

`int result2 = num1 / num2 * num2;` --> 2

`double result = num1/num2` --> 2.0

`double result3 = num1 /(num2+0.0);` -->2.4

`double result4 = (double)num1/num2;` -->2.4



#### % 取模符号

结果的符号与被模数相同 m%n, m是被模数

#### ++, --

不管自增还是自减，它们都有前后的区别

Q：为什么要用自增或自减？

`s1++`

`short s1 = 10; s1 = (short)(s1+1);` 

上面两行语句都是实现s1本身加1，但是自增不需要另外强制转换类型，效率明显更高

Q：请思考为什么？

```java
byte a = 127;
a++;
System.out.println("a = " + a);
--> -128 //why?
```

#### Quiz: how to print every position of a integer?

```java
class PrintInteger{
    public static void main(String[] args){

        int num = 187;
        
        int bai = num / 100;
        int shi = num % 100 / 10;
        int ge = num % 10;

        System.out.println("数字的情况如下：");
        System.out.println("个位数：" + ge);
        System.out.println("十位数：" + shi);
        System.out.println("百位数：" + bai);

    }
}
```

### 赋值运算符

`s1 += 2 // s1 = s1 +2`  想想二者之间的区别

##### Quiz

1. 

```java
int i = 1;
i *= 0.1;
System.out.println(i);
i++;
System.out.println(i);
```

​	*= 运算符不会改变数据类型，也就是说i还是int，但是0.1是double型，所以是强制转换成int型，强制转换就是	截断，i *= 0.1的结果是0

2. 

```java
int m = 2;
int n = 3;
n *= m++;
System.out.println("m= " + m);
System.out.println("n= " + n);
```

3. 

```java
int n1 = 10;
n1 += (n1++) + (++n1);
System.out.println(n1);
```

### 比较运算符

比较运算的结果都是boolean型

### 逻辑运算符

 #### &, &&

二者的运算结果是相同的

当符号左边为true时，二者都会执行符号右边的运算

！当符号左边为false时，&会继续执行符号右边的运算，而&&不再执行符号右边的运算！

例子

```java
boolean b1 = true;
b1 = false;
if(b1 & (num1++ > 0)){ 
  System.out.println("iddd");
}
else{
  System.out.println("eeee");
}
System.out.println("num1 = " + num1);
```

```java
boolean b2 = true;
b2 = false;
if(b2 & (num2++ > 0)){
  System.out.println("iddd");
}
else{
  System.out.println("eeee");
}
System.out.println("num2 = " + num2);
```

#### |, ||

！当符号左边为true时，|会继续执行符号右边的运算，而||将不再继续执行符号右边的运算！

开发中优先使用短路与和短路或

#### Quiz

```java
class Test{
  public static void main(String[] args){
    boolean x = true;
    boolean y =false;
    short z = 42;
    // if(y == true)
    if((z++ == 42) && (y = true)) 
      z++;
    if((x = false) || (++z == 45)) 
      z++;
    System.out.println("z = " + z);
  }
}
// 前自增，后自增，与，短路与，或，短路或
```

### 位运算符

位运算符都是以计算机底层二进制来计算的



<<: 在一定范围内，每向左移1位，相当于 *2

">>": 要一定范围内，每向右移1位，相当于 /2

">>>": 无符号右移

&, |, ^

### 三元运算符（三目）

结构：（条件表达式）？表达式1：表达式2

表达式1和表达式2要求是一致的

三元运算符可以嵌套

如果程序既可以使用三元又可以用if-else，那么优先使用三元，因为更简洁，效率更高

### 运算符的优先级

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220616190529132.png" alt="image-20220616190529132" style="zoom: 67%;" />

## 程序流程控制

### 如何从键盘获取变量

使用Scanner类

具体实现步骤：

1. 导包：import java.util.Scanner;
2. Scanner的实例化：`Scanner scan = new Scanner(System.in);`

3. 调用Scanner类的相关方法，来获取指定类型的变量

   next( ), nextXxx( )...

4. 对于char型的获取，Scanner没有提供相关的方法，所以只能通过获取字符串

5. 注意：需要根据相应的方法，来输入指定类型的值。如果输入的数据类型与要求的类型不匹配时，会报异常InputMisMatchExcpet，导致程序终止

Q: 80 < score <= 99，请问java里可以这么写吗？为什么？

​	从左往右计算的话，会先得出来布尔型的结果，布尔型数值与99进行算术运算，结果会报错

### if-else

1. else结构是可选的

2. 如果多个条件表达式之间是 “互斥” 关系（没有交集关系），哪个判断和执行语句声明再上面还是下面，无所谓

   但是如果多个条件表达式之间有交集关系，那就需要根据实际情况，考虑哪个结构应声明再上面

   若是之间有包含关系，通常情况下，需要将范围小的放在范围大的上面

3. if-else 结构是可以嵌套的

   但是开发中嵌套不会很多

4. else 有就近原则

#### Quiz01

```java
int x = 4;
int y = 1;
if(x > 2){
  if(y > 2) // 考点：没有大括号情况下的结构
    System.out.println(x + y); // 在没有大括号下默认在里面只有一条语句
  	System.out.println("atguigu"); // 所以这条语句其实是属于当 y > 2 不成立的时候执行的
  	// 总的来说，不建议这种写法，让人看不懂
}else
  	System.out.println("x is " + x);

// -->请问输出结果是什？
// atguigu
// why?
```

#### Quiz02

```java
import java.util.Scanner;

public class IfÜbung01 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("请输入你的身高: (cm)");
        int height = scan.nextInt();

        System.out.println("请输入你的财富: (千万)");
        double wealth = scan.nextDouble();

        System.out.println("请输入你是否帅: (true/false)");
        boolean isHandsome = scan.nextBoolean();

        if(height >= 180 && wealth >= 1 && isHandsome){
            System.out.println("yes, i do");
        }else if(height >= 180 || wealth >= 1 || isHandsome){
            System.out.println("okay");
        }else{
            System.out.println("NO!");
        }
    }
}
```



### 获取随机数 Math.random

> ```
> public static double random()
> ```
>
> Returns a **double** value with a positive sign, greater than or equal to **0.0** and less than **1.0**. Returned values are chosen pseudorandomly with (approximately) uniform distribution from that range.

range of random [0.0, 1.0)

Q: then how can i get a random number from 10 to 99? [10, 99]

A: `int value = (int)(Math.random()*90 + 10)`

in general, how can i get [a, b]

: `(int)(Math.random()*(b-a*1))+a)`

### switch-case 

**什么时候使用switch-case， 什么时候使用if-else?**

break 跳出switch-case 的结构，大部分情况都是需要加的

switch结构中的表达式只能是如下的6种数据类型之一：byte, short, char, int, 枚举类型(JDK 5.0)，String(JDK 7.0)

case 之后不能声明范围

default 相当于if-else中的else, default是可选的，并且它的位置是灵活的

#### Quiz01_transfer 'a', 'b', 'c', 'd', 'e' to cpital letter

```java
import java.util.Scanner;

public class SwitchCase01 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a word: ");
        String word = scan.next();
        char c = word.charAt(0);
        switch(c){
            case 'a':
                System.out.println("A");
                break;
            case 'b':  
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
```

#### Quiz02_多个case合并例子

```java
public class SwitchCase02 {
    public static void main(String[] args){
        int score = 78;
        switch(score / 10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("不及格");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("及格");
                break;
        }
    }
}
```

#### Quiz02-01_判断60以下不及格

```java
public class SwitchCase02 {
    public static void main(String[] args){
        int score = 78;
        switch(score / 60){
            case 0: 
                System.out.println("不及格");
    						break;
            case 1:
                System.out.println("及格");
    						break;
        }
    }
}
```

#### Quiz03_判断某年某月某日是这一年的第几天（考虑闰年）

```java
/*
    已知 年月日，求出这是这一年的第几天
    要考虑到闰年的二月份是29天
    判断闰年的标准：可以被4整除但是不能被100整除
    或者可以被400整除
 */
import java.util.Scanner;

public class SwitchCase03 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the year: ");
        int year = scan.nextInt();
        System.out.println("Please enter the month: ");
        int month = scan.nextInt();
        System.out.println("Please enter the date: ");
        int date = scan.nextInt();
        
        int sumDays = 0;
        switch(month){
        // bitte denke darüber nach, warum es hier rückwärts geschrieben ist.
        // und warum ohne "break"
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if(year % 400 == 0){
                    sumDays += 29;
                }else{
                    sumDays += 28;
                }
            case 2:
                sumDays += 31;
            case 1:
                sumDays += date;
        }
        System.out.println(date + "." + "of " + month + " is the " + sumDays + ".day in " + year);
    }
}
```

## 循环结构

### for 循环

循环条件是boolean类型

#### Quiz01

 ```java
 int num = 1;
 for(System.out.println('a'); num <= 3; System.out.println('c', num++)){
   System.out.println('b');
 }
 --> abcbcbc
 ```

#### Quiz02_找偶数并求和

```java
public class Quiz{
  public static void main(String[] args){
    int sum = 0; //记录偶数之和
    int count = 0; //记录偶数个数
    for(int i = 1; i <= 100; i++){
      if (i % 2 == 0){
        System.out.println(i);
        count++;
        sum += i;
      }
      System.out.println("in total is: " + sum);
      System.out.println("we have " + count + " odd number");
    }
  }
}
```

#### Quiz03

```java
/*
 * 从1循环到150，并在每一行打印一个值
 * 另外在每个3的倍数行上打印出“foo”
 * 在每个5的倍数行上打印出“biz”
 * 在每个7的倍数行上打印出“baz”
 */


public class ForTest01 {
    public static void main(String[] args){
        for(int i = 1; i <= 150; i++){
            // if(i % 3 == 0){
            //     System.out.println(i + " foo");
            // }else if(i % 5 == 0){
            //     System.out.println(i + " biz");
            // }else if(i % 7 == 0){
            //     System.out.println(i + " baz");
            // }else{
            //     System.out.println(i);
            // }
            // 发现问题了
            // 如果一个数既是3的倍数，又是5的倍数，或有时7的倍数，那怎么办
            // 所以不能使用else
            System.out.print(i);

            if(i % 3 == 0){
                System.out.print(" foo");
            }
            if(i % 5 == 0){
                System.out.print(" biz");
            }
            if(i % 7 == 0){
                System.out.print(" baz");
            }

            System.out.println();
        }
    }
}
```

#### Quiz04_最大公约数和最小公倍数

```java
/*
 * 求两个整数的最大公约数和最小公倍数
 * 公约数：能同时被两个数整除
 * 公倍数：同时是两个数的倍数
 * 求最大公约数：确定一个范围，从后往前找，这个范围是最小不小于1，最大不大于两个数中的较小值
 * 求最小公倍数：同样确定一个范围，但是因为这里是求最小，所以要从小开始找，找到的第一个公倍数就是最小的。那么范围是什么呢？最小不小于两数中的较大数，最大不大于两数的积
 * 一个从大开始找，一个从小开始找，找到的第一个数就是我们要的最大公约数和最小公倍数
 * 那么如何实现找到第一个数后就跳出循环呢？ --> break
 */
import java.util.Scanner;

public class ForTest02 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter a positive integer: ");
        int m = scan.nextInt();
        System.out.println("Please enter one more positive integer: ");
        int n = scan.nextInt();

        // 求最大公约数
        //get smaller number
        int min = (m <= n)? m : n;
        for(int i = min; i >= 1; i--){
            if(m % i == 0 && n % i == 0){
                System.out.println("Maximum Convention: " + i);
                break; // 找到的第一个i就是最大公约数，所以用break直接跳出循环
            }
        }

        // 求最小公倍数
        int max = (m >= n)? m : n;
        for(int i = max; i <= m * n; i++){
            if(i % m == 0 && i % n == 0){
                System.out.println("Least Common Multiple: " + i);
                break;
            }
        }
    }
}
```

#### Quiz05_水仙花数

```java
/*
 * 水仙花数: 一个3位数，其各个位上数字立方和等于其本身
 * 输出所有水仙花数
 * 关键是：如何求出各个位上的数
 * 另外：在java中如何求三次方呢？a*a*a, a^3是错的
 */
public class ForTest03 {
    public static void main(String[] args){

        for(int i=100; i < 1000; i++){
            int hundredDigit = i / 100;
            int tenDigit = i % 100 / 10;
            int singleDigit = i % 10;
            int sum = hundredDigit*hundredDigit*hundredDigit + tenDigit*tenDigit*tenDigit + singleDigit*singleDigit*singleDigit;
            if( sum == i){
                System.out.print(i + "\t");
            }    
        }
    }
}
```

### while-loop

写while循环要小心不要丢了迭代条件，一旦丢了，就有可能出现死循环

for和while的初始化条件的作用域不同

for的初始化条件出了循环就不能再调用了，而while可以

### do-while

开始就执行一次循环体

然后在判断循环条件

所以do-while循环至少会执行一次循环体

### Quiz of Loop

```java
/*
 * 从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序
 * 用posNum和negNum来记录正数和负数的个数
 * 用break跳出循环
 */
import java.util.Scanner;


public class LoopQuiz01 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int posNum = 0;
        int negNum = 0;

        System.out.println("Please enter nums: ");

        while(true){ // for(;;)
            int number = scan.nextInt();

            if(number > 0){
                posNum++;
            }else if(number < 0){
                negNum++;
            }else{
                break;
            }
        }
        
        System.out.println("the number of positive integer is: " + posNum);
        System.out.println("the number of negative integer is: " + negNum);
    }
}
```

### NestedLoops

一个循环结构声明在另一个循环的循环体中

外层循环控制行数，内层循环控制列数

#### Quiz01

```java
/*
*
**
***
****
*****
*/
public class NestedLoop01 {
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

#### Quiz02

```java
/*
*****
****
***
**
*
*/
public class NestedLoop02 {
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            for(int j = 5; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
```

#### Quiz03

```java
/*
123456789
    *
   * *
  * * *
 * * * *
* * * * *

这一类型的题目可以多联系，对确定循环条件很有帮助，嵌套循环很容易弄混了
比如打印各种形状
*/
public class NestedLoop03 {
    public static void main(String[] args){
        for(int i = 1; i <= 5; i++){
            // for(int j = 5 - i;j >= 0; j--){
            for(int j = 1; j <= 5 - i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
```

#### Quiz04_NineNineTable

```java
/*
 * print a NineNineTable
 * Chinese Multiplication Table
 */

public class NestedLoop04 {
    public static void main(String[] args){
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.println();
        }
    }
}
/*
1 * 1 = 1 
2 * 1 = 2 2 * 2 = 4 
3 * 1 = 3 3 * 2 = 6 3 * 3 = 9 
4 * 1 = 4 4 * 2 = 8 4 * 3 = 12 4 * 4 = 16 
5 * 1 = 5 5 * 2 = 10 5 * 3 = 15 5 * 4 = 20 5 * 5 = 25 
6 * 1 = 6 6 * 2 = 12 6 * 3 = 18 6 * 4 = 24 6 * 5 = 30 6 * 6 = 36 
7 * 1 = 7 7 * 2 = 14 7 * 3 = 21 7 * 4 = 28 7 * 5 = 35 7 * 6 = 42 7 * 7 = 49 
8 * 1 = 8 8 * 2 = 16 8 * 3 = 24 8 * 4 = 32 8 * 5 = 40 8 * 6 = 48 8 * 7 = 56 8 * 8 = 64 
9 * 1 = 9 9 * 2 = 18 9 * 3 = 27 9 * 4 = 36 9 * 5 = 45 9 * 6 = 54 9 * 7 = 63 9 * 8 = 72 9 * 9 = 81 
*/
```

#### Quiz05_100000以内的所有质数 PrimeNumber

```java
/*
 * print prime number within 100000
 * prime number: if it is greater than 1 and cannot be written as the product of two smaller natural numbers
 * the smallest prime number is 2
 * 注意几种优化方法：
 * 1. break
 * 2. 内层循环: for(int j = 2; j <= Math.sqrt(i); j++){}
 *    也就是j的范围有改进，只需要小于i的开方
 * 3. 只要统计总共有多少个质数，不需要将每个都打印出来
 */


public class NestedLoop05 {
    public static void main(String[] args){
        boolean isFlag = true;

        long start = System.currentTimeMillis();

        int count = 0;

        for(int i = 2; i <= 100000; i++){
        // 2 是质数，请问2是否会被输出，为什么？
            // for(int j = 2; j < i; j++){
            for(int j = 2; j <= Math.sqrt(i); j++){ // 优化方法2：对本身是质数的自然数是有效的
            /*
             * 为什么j的范围小于i的开方就可以？
             * 比如说i为100
             * 原本的j的范围是2-99，也就是说在2-99之内如果可以找到一个数可以被100除尽，那就说明100是质数
             * 如果找到了某个j可以被除尽，那100/j的结果为k，若是j比k小，那是不是如果从2开始找的话，会先找到j，那找到了j之后，其实k就不需要再去找了
             * 既然这样的话，那j和k会是大概怎么分布呢？
             * 假设 a * b = 100，我们知道100开方的结果是10，所以 a和b可以都是10
             * 那么a < 10的时候，b 必须 > 10，所以任意一对a和b都是分布在10的两边，或者都是10
             * 这一结果也应用于任何数
             * 所以，只要在 2 <= j <= Math.sqrt(i) 的范围内找有没有a，不需要考虑b，因为b就是在另一边
             */
                
                
                if(i % j == 0){
                    /*
                    * 思路
                    * 为什么不能直接写 if(i % j != 0)? 如果if语句的条件这么写，那么if的主体该执行什么呢？
                    * 如果写 if(i % j == 0)的话，主体中的执行语句又该怎么写呢？
                    * 能否总结一下定义这个isFlag的标志有哪些情况呢？
                    */
                    isFlag = false;    
                    break; // 优化方法1:只对本身非质数的自然数是有效的
                    /*
                     * 进入这个循环的条件是：对于i来讲，在2到i-1的范围内，找到了某个j可以整除i，也就是说i不是质数
                     * 那么反过来说，如果i是一个质数，那么在内层循环中是不会进入if的主体执行语句中的，那么ifFlag就会保持true
                     * 
                     */
                }
            }
            if(isFlag == true){
            // 所以基于上述的条件判断后，若是ifFlag保持true，就意味着这个i是质数，那就可以将其打印出来
            // 注意：这两个条件判断都是在大的外层循环之内的，也就是说，i每次+1后都要再次执行这个两个判断
                // System.out.println(i);
                // 不需要输出的话，节省了好几倍的时间
                count++;
            }
            isFlag = true; // 重置isFlag
            /*
            * 为什么需要重置isFlag？
            * 2和3都是质数，所以当i为2，3的时候，不会进入第一个判断，所以isFlag保持为true
            * i来到4的时候，因为4可以被2整除，所以此时会进入第一个判断，那么isFlag就变为false
            * 所以4不会被输出
            * 然后i就来到5，5是质数，所以不会进入第一个判断
            * 但是！
            * isFlag仍然是false，因为在i为4的时候，isFlag被置为false，那么5就不会被输出
            * 并且isFlag会一直保持为false
            * 所以
            * 如果没有重置isFlag，那么执行整个程序之后只会输出2和3
            */        
        }

        System.out.println(count);

        long end = System.currentTimeMillis();
        
        System.out.println("所花费的时间：" + (end - start));
        // without break: 6683 ms
        // with break: 625 ms
        // with berak & sqrt(i): 104 ms
        // with break & sqrt(i), without printing out
    }
}
```

#### Quiz06_PrimeNumber

```java
public class NestedLoop05_PrimeNumber02 {
    public static void main(String[] args){

        long start = System.currentTimeMillis();
        
        int count = 0;

        label: for(int i = 2; i <= 100000; i++){

            for(int j = 2; j <= Math.sqrt(i); j++){

                if(i % j == 0){
                    continue label;
                    // 只要i能被除尽，说明这个i就不是质数，那就跳出当次循环，i往前再来循环
                }
            }
            count++;
        }

        long end = System.currentTimeMillis();

        System.out.println(count);
        System.out.println("所花费的时间：" + (end - start));
    }
}
```

#### Quiz07_PerfectNumber

```java
/*
 * ********************************** Perfect Number *********************************
 * n number theory, 
 * a perfect number is a positive integer that is equal to the sum of its positive divisors, 
 * excluding the number itself.
 * ************************************** Analyse ************************************
 * 要确认某一个数是不是完数，给某个数设一个变量i，范围是从1到1000，那就需要第一个循环，逐个确认当前的i是不是完数（外层循环）
 * 外层循环：for(i = 1; i <= 1000; i++)
 * 要确定某个i是不是完数，那就要找出当前这个数的除了本身之外的所有因数，那么如何找到它的因数呢？
 * 找某个数的因数，那有需要一层循环，也就是内层循环，用变量j来找因数
 * 内层循环：for(j = 1; j < i; j++)
 * 这里用循环的停止条件 j < i 没有问题，但是不高效，和找质数的道理是相同的
 * 那么怎么样的j才是i的因数呢？或者说i和j关系是什么，才能证明j是i的因数呢？
 * i % j == 0
 */


public class PerfectNumber {
    public static void main(String[] args){

        int sum = 0;

        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= i/2; j++){
            /*
             * for(int j = 1; j < i; j++){
             * 思考：为什么可以把j的范围改为 <= i/2?
             * 其实换句话问就更明白：某个整数的因子有可能比它本身的一半还要大吗？
             * 首先，因子都是两两对应的，我们可以从两边的极端向中间找
             * 如果1作为其中一个因子，那么另一个必须是本身，数的本身在这里不算
             * 那么如果2作为其中的一个因子，那么另一个因子是多少？或者它的范围是多少？
             * 范围必定小于等于这个数本身的一半
             * 那如果是3作为其中的一个因子，那么另一个对应的因子就更小
             * 因此
             * 某个整数的因子最大不会大于本身的1/2，所以得出 j <= i/2;
             */
                if (i % j == 0){
                    sum += j;
                }
            }
            if( i == sum){
                System.out.println(i);
            }
            // 一定要重置sum
            sum = 0;
        }
    }
}
```

### "无限循环"结构

`while(true)`

`for(;;)`

当我们不知道循环次数时，可以使用“无限循环”

### break, continue 关键字的使用

break 结束当前循环，默认跳出包裹此关键字最近的一层循环，那如何跳出指定的某层循环呢？

​		**加上一个标签lable**

```java
label: for(int i = 1; i <= 4; i++){
  for(int j = 1; j <= 10; j++){
    if(j % 4 == 0){
      // break label; 结束指定标识的一层循环结构
      // continue label; 结束指定标识的一层循环结构当次循环
    }
    System.out.print(j);
  }
}
```

continue 结束当次循环

### return 

return 结束的是方法

## Array

数组本身属于引用数据类型的变量，但是数组的元素可以时基本数据类型，也可以是引用数据类型

连续内存空间

确定的数组的长度不能修改

### 数组初始化

数组声明： `int[] ids;`

1. 静态初始化：数组的初始化和数组元素的赋值操作同时进行

`ids = new int[]{1001, 1002, 1003, 1004};`

2. 动态初始化：数组的初始化和数组元素的赋值操作分开进行

`String[] names = new String[5];`

数组一旦初始化完成，其长度就已经确定了

### 数组元素的默认初始化值

数组元素是整型：0

数组元素是浮点型：0.0

数组元素是char型：0 (是ACSII码的0，而不是'0')

数组元素是boolean型：false  (计算机底层存储时，0代表false)

数组元素是*引用数据类型*时：null

### 数组的内存解析

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/Bildschirmfoto 2022-06-23 um 10.13.20.png" alt="Bildschirmfoto 2022-06-23 um 10.13.20" style="zoom:70%;" />

局部变量：放在方法中的变量都叫局部变量

自动垃圾回收过程

#### 一维数组的内存解析

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/Bildschirmfoto 2022-06-23 um 10.49.57.png" alt="Bildschirmfoto 2022-06-23 um 10.49.57" style="zoom:40%;" />

了解每一行代码运行时，计算机底层发生的事：

```java
int[] arr = new int[]{1,2,3}; //静态初始化
String[] arr1 = new String[4]; //动态初始化
arr1[1] = "fee";
arr2[2] = "www";
arr1 = new String[3]; //动态初始化
System.out.println(arr[1]); //null
```

### 多维数组

二维数组是一维数组array1又作为另一个一维数组array2的元素

从数组底层的运行机制来看，其实没有多维数组

#### 多维数组的基本操作

```java
package com.atguigu.java;

public class ArrayTest01 {
	public static void main(String[] args) {
		//一维数组的声明和初始化
		int[] arr = new int[] {1, 2, 3};
		
		//二维数组的静态初始化
		int[][] arr1 = new int[][] {{1,2,3},{4,5},{6,7,8}};
		
		//二维数组的动态初始化1
		String[][] arr2 = new String[3][2];
		
		//二维数组的动态初始化2
		String[][] arr3 = new String[3][];
		arr3[1] = new String[4]; //	请问这行什么意思？如何理解？（与数组的内存解析有关）
		
		//也可以这么写
		int[] arr4[] = new int[][] {{1,2,3},{4,5,9,10},{6,7,8}};
		int[] arr5[] = {{1,2,3},{4,5},{6,7,8}};
		
		//length
		System.out.println(arr4.length); // -->3
		System.out.println(arr4[0].length);	// -->3
		System.out.println(arr4[1].length);	// -->4
		
		//遍历二维数组
		for(int i = 0; i < arr4.length; i++) {
			for(int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

#### 多维数组元素的默认值

```java
/*
 * 多维数组元素的默认值（不好理解），重点就在于要理解不管是一维还是多维数组在计算机底层的存储逻辑
 */

package com.atguigu.java;

public class ArrayTest02 {
	public static void main(String[] args) {
		
		// 分析一下以下各个不同情况下的输出值是什么
		
		System.out.println("********** case1 **********");
		// case1
		int [][] arr = new int[4][3];
		System.out.println(arr[0]);		// 对于外层数组而言，它里面存了内层数组，外层数组是如何与内层数组联系的呢？
										// 或者说在外层数组中要存储（内层数组的）什么值，才能找到内层数组呢？
										// 答案是：地址 --> [I@15db9742
										// 这就涉及到了计算机底层的存储逻辑，物理存储逻辑
		System.out.println(arr[0][0]);	// 0, 默认的int类型的值就是0，这和一维数组的原理是一样的
		
		System.out.println("********** case2 **********");
		// case2
		float[][] arr1 = new float[4][3];
		System.out.println(arr1[0]);	// 与上一个案例相同，也是某个地址
										// [F@6d06d69c
		System.out.println(arr1[0][0]);	// 0.0，这与一维数组也是相同的
		
		System.out.println("********** case3 **********");
		// case3
		String[][] arr2 = new String[4][2];
		System.out.println(arr2[1]);	// 还是地址：[Ljava.lang.String;@7852e922
		System.out.println(arr2[1][1]);	// null，和一维数组一样，String是引用数据类型
		
		System.out.println("********** case4 **********");
		// case4 
		double[][] arr3 = new double[4][];
		System.out.println(arr3[1]);	// 为什么这里是null，而不是地址？
										// 想想看，[]这个意味着什么？
										// 其实计算机都没有给内层数组开辟空间，哪来的地址？
		System.out.println(arr3[1][0]);	// 既然空间都没有开辟，你去找肯定找不到，就会报错！！
		
	}
}
```

规律小结：

1. `int[][] arr = new int[4][3];`

   外层元素的初始化值：地址值

   内层元素的初始化值：与一维数组一样

2. `int[][] arr = new int[4][];`

   外层元素的初始化值：null

   内层元素的初始化值：报错，因为连空间都没有开辟出来，去哪找...

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220623154200499.png" alt="image-20220623154200499" style="zoom:50%;" />

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220623154331038.png" alt="image-20220623154331038" style="zoom:50%;" />

什么是类型推断？

### 数组中涉及的常见算法

1. 数组元素的赋值（杨辉三角、回形数等）
2. 求数值型数组中元素的最大值、最小值、平均数、总和等
3. 数组的复制、反转、查找（线性查找、二分法查找）
4. 数组元素的排序算法

#### 1. Yanghui 

```java
package com.atguigu.exer;

/*
 * 题目：使用二维数组打印一个10行的杨辉三角
 * 提示：
 * 1. 第一行有1个元素，第n行有n个元素
 * 2. 每一行的第一个元素和最后一个元素都是1
 * 3. 从第三行开始，对于非第一个元素和最后一个元素的元素来说的规律是：
 * 	  yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j]; 
 */

public class YangHui {
	public static void main(String[] args) {
		// 1. 声明并初始化二维数组
		int[][] yangHui = new int[10][]; // 为什么是10不是9？初始化时给的数值是指数组长度，不是指下标
		
		// 外层循环
		for(int i = 0; i < yangHui.length; i++) {
			
			// 1.1 初始化内层数组
			yangHui[i] = new int[i + 1];
			
			// 内层循环
			// 2. 给数组的元素赋值（想想这一段为什么这么写可以，虽然是自己写的，和song的也不一样，但是并没有完全弄懂）
			for(int j = 0; j < yangHui[i].length; j++) {
				if( j == 0 || i == j) {
					yangHui[i][j] = 1;
				}else {
					// 主要的点就是这里，为什么可以直接用if-else解决
					yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j]; 
				}
			}
		}
		
		// 3. 遍历二维数组
		for(int i = 0; i < yangHui.length; i++) {
			for(int j = 0; j < yangHui[i].length; j++) {
				System.out.print(yangHui[i][j] + " ");
			}
			System.out.println();
		}
	}
}
```

#### 2. 求数值型数组中元素的最大值、最小值、平均数、总和等

```java
package com.atguigu.exer;

/*
 * 从[10,99]的范围内随机生成10个数，求它们的和，最大值，最小值，平均数
 * 要弄清楚如何在某个范围内产生随机数
 */


public class ArrayExercise04 {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(99 - 10 + 1) + 10);
		}
		
		//遍历
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "\t");
		}
		System.out.println();
		
		//maximum
		int maxValue = arr[0];	//请问为什么初始值不能为0？
		for(int i = 1; i < arr.length; i++) {
			if(maxValue < arr[i]) {
				maxValue = arr[i];
			}
		}
		System.out.println("maximum is: " + maxValue);
		
		// minimum
		int minValue = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(minValue > arr[i]) {
				minValue = arr[i];
			}
		}
		System.out.println("minimum is: " + minValue);
		
		//sum
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum is: " + sum);
		//average
		int average = sum/10;
		System.out.println("average is: "+ average);
	}
}

```

#### 3. 数组的复制、反转、查找（线性查找、二分法查找）

 ```java
 package com.atguigu.exer;
 
 public class ArrayAlgo03 {
 	public static void main(String[] args) {
 		String[] arr = new String[] {"JJ", "DD", "MM", "BB", "GG", "AA"};
 		
 		// 数组的复制（要和数组的简单赋值：arr1 = arr 区别开）
 		String[] arr1 = new String[arr.length];
 		for(int i = 0; i < arr1.length; i++) {
 			arr1[i] = arr[i];
 		}
 		
 		//数组的反转，前后交换，第一和最后换，第二和倒数第二换
 		// 反转方法一
 //		for(int i = 0; i < arr.length / 2; i++) {
 //			String temp = arr[i];
 //			arr[i] = arr[arr.length - i - 1];
 //			arr[arr.length - i - 1] = temp;
 //		}
 		
 		// 反转方法二
 		for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
 			String temp = arr[i];
 			arr[i] = arr[j];
 			arr[j] = temp;
 		}
 		//遍历
 		for(int i = 0; i < arr.length; i++) {
 			System.out.print(arr[i] + "\t");
 		}
 	}
 }
 ```

#### 3.Search(线性查找，二分查找)

```java
package com.atguigu.exer;

public class ArrayAlgoSearch {
	public static void main(String[] args) {
		
		//线性查找法
	
		boolean isFlag = true;
		
		for(int i = 0; i < arr.length; i++) {
			if(goal.equals(arr[i])) {
				System.out.println("found: " + i);
				isFlag = false;
				break;
			}
		}
		if(isFlag) {
			System.out.println("did find");
		}
		
		//二分查找，二分法的前提是有序
		int[] arr2 = new int[] {-98, -45, -12, 1, 22, 43, 45, 89, 100, 120, 320};
		
		int goal1 = 89;
		int head = 0;
		int end = arr2.length - 1;
		boolean isFlag1 = true;
		while(head <= end) {
			int middle = (head + end) / 2;
			if(arr2[middle] == goal1) {
				System.out.println("found: " + middle);
				isFlag1 = false;
				break;
			}else if(arr2[middle] < goal1){
				head = middle + 1;
			}else {
				end = middle - 1;
			}
		}
	}
}
```

#### 4.Sort(Bubble)

```java
package com.atguigu.exer;

public class ArrayAlgoSort {
	public static void main(String[] args) {
		
		//BubbleSort
		int[] arr = new int[] {2, 34, 53, 92, 1, 129, 23, 44};
		
		for(int i = 0; i < arr.length - 1; i++) {
		// 总共比较 length-1 轮
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//遍历
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
}
```

#### 4.1 QuickSort

### Arrays工具类的使用

java.util.Arrays类 即为操作数组的工具类，包含了用来操作数组（比如排序，搜索）的各种方法

常见操作的例子

```java
package com.atguigu.java;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		
		//1. boolean equals(int[] a, int[] b): 判断两个数组是否相等
		int[] arr1 = new int[] {4,2,1,10};
		int[] arr2 = new int[] {1,3,2,4};
		boolean isEqual = Arrays.equals(arr1, arr2);
		System.out.println(isEqual);
		
		//2. String toString(int[] a): 输出数组信息
		System.out.println(Arrays.toString(arr1));
		
		//3. void fill(int[] a, int val): 将指定数值填充到数组中
		Arrays.fill(arr2, 2);
		System.out.println(Arrays.toString(arr2));
		
		//4. void sort(int[] a): 对数组进行排序
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		//5. int binarySearch(int[] a, int key)
		int[] arr3 = new int[] {12, 23, 44, 92, 14, 65, -12, -90, 1212};
		int index = Arrays.binarySearch(arr3, -90); //为什么这里找不到
		System.out.println(index);
		
	}
}
```

### Exception

常见两种异常：下标越界和空指针

```java
package com.atguigu.java;

/*
 * 数组中常见的异常 Exception
 * 1. 数组角标越界的异常 ArrayIndexOutOfBoundsException
 * 
 * 2. 空指针异常 NullPointerException
 */

public class ArrayExceptionTest {
	public static void main(String[] args) {
		
		//1. 数组角标越界的异常
		int[] arr = new int[] {1,2,3,4,5};
		for(int i = 0; i <= arr.length; i++) {
			// 因为有了等号，但是数组直到arr.length-1
			System.out.println(arr[i]);
		}
		System.out.println(arr[-2]);//同样会出现异常情况
		
		//2. 空指针异常
		//2.1
		int[] arr1 = new int[] {1,2,3};
		arr1 = null;
		System.out.println(arr1[0]);
		
		//2.2
		int[][] arr2 = new int[3][]; //注意这里的数值指的是数组长度，不是下标
		System.out.println(arr2[1]);
		
		//2.3
		String[] arr3 = new String[] {"aa", "bb", "cc"};
		arr3[0] = null;
		System.out.println(arr3[0].toString());
		// System.out.println(arr3[0]) --> null
		// 为什么上面这行就不会报错，而是会输出null
	}
}
```

### Quiz 

1. 冒泡排序 

   `int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};`

2. 反转上面的数组

3. 复制上面的数组（要和赋值区分）

4. 使用线性查找，从上面的数组中查找是否存在22，若存在，输出位置下标，若不存在，输出提示信息

   ```java
   public class Search{
     public static void main(String[] args){
       int[] arr = new int[]{34,5,22,-98,6,-76,0,-3};
       int goal = 22;
       boolean isFlag = false;
       for(int i = 0; i < arr.length; i++){
         if(goal == arr[i]){
           System.out.print(i);
           isFlag = true;
           break;
         }
       }
       if(!isFlag){
         System.out.print("didn't find");
       } 
     }
   }
   ```

## main( ) 方法

P329 - Kang

1. main( ) 方法作为程序的入口
2. main( ) 方法也是一个普通的静态方法
3. main( ) 方法可以作为我们与控制台交互的方式

# 3 OOP

## Philosophy of OOP

如何理解 “万事万物皆对象”

1. 在Java语言的范畴中，我们都将功能、结构等封装到类中，再通过类的实例化来调用具体的功能结构
2. 涉及到Java语言与前端HTML、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象

## Main lines of OOP

- java class and members of class
  - attributs
  - method
  - constructor
  - 代码块、内部类
- 3 main features of oop
  - encapsulation
  - inheritance
  - polymorphism
- other keywords

# Class vs. Instance

### Def.

- Class
- Instance



- 类：对一类事物的描述，是抽象的、概念上的定义

​		面向对象程序设计的重点就是**类的设计**

​		设计类就是设计类的成员：

​		属性 field = 成员变量  = 域、字段

​		方法 method = 成员方法 = 函数 

对象：实际存在的某一类事物的每个个体，也称为实例instance

​			*存在匿名对象，什么事匿名对象？



### 类和对象的使用（也就是面向对象这种思想的落地）

1. 创建类，设计类的成员
2. 创建类的对象
3. 用过“对象.属性”或“对象.方法” 调用对象的结构

### 对象之间彼此独立

同一个类的多个对象彼此独立，每个对象都有自己独立的一套类的属性（非static的）

所以如果修改其中一个对象的属性，并不会影响另外对象的属性

### 对象的内存解析

### 属性（成员变量）vs 局部变量

1. 相同点

​		1.1 定义变量的格式： 数据类型 变量名 = 变量值

​		1.2 先声明，后使用

​		1.3 变量都有其对应的作用域

2. 不同点

   2.1 在类中声明的位置不同

   属性：直接定义在类的一对{}内

   局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量

   2.2 权限修饰符的不同

   属性：可以在声明属性时，指明其权限，使用权限修饰符

   ​			常用的权限修饰符access modifier：private, public, protected, 缺省

   局部变量：不可以使用权限修饰符

   2.3 默认初始化值的情况

   属性：类的属性根据其类型都有初始化值

   ​			和一维数组的初始化值完全相同

   局部变量：**没有默认初始化值**

   ​					所以在调用局部变量之前，一定要显式赋值

   ​					特别地，形参在调用时，我们赋值即可

   2.4 在内存中加载的位置不同

   属性：加载到堆空间

   局部变量：加载到栈空间

### 子类对象实例化的全过程

1. 从结果上来看：（就是继承性）

   子类继承父类以后，就获取了父类中声明的属性或方法

   创建子类的对象，在堆空间中，就会加载所有父类中声明的属性

2. 从过程上来看：

   当我们通过子类的构造器创建子类对象时，**我们一定会直接或间接地调用其父类的构造器**，进而调用父类的父类的构造器，直到调用了java.lang.Object类中空参的构造器为止。

   （<u>所谓继承性的底层逻辑就是当我们通过子类构造器创建子类对象的时候，一定直接或间接地调用了所有父类的构造器！！</u>）

   正因为加载过所有的父类的结构，所以才可以看到内存中有父类中的结构，子类对象才可以考虑进行调用

   <img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220707105805086.png" alt="image-20220707105805086" style="zoom:30%;" />

   <img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220707110251548.png" alt="image-20220707110251548" style="zoom:40%;" />

3. **但是**要明确的是：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象

   **调用父类构造器 != 造父类对象**



### Quiz1

#### MatrixTest

```java
package com.hurjiang.exercise;

/*
 * 3.1 编写程序，声明一个method方法，在方法中打印一个10*8 的*型矩形， 
 *     在main方法中调用该方法。
 * 3.2 修改上一个程序，在method方法中，除打印一个10*8的*型矩形外，
 * 	   再计算该矩形的面积，并将其作为方法返回值。在main方法中调用该方法， 
 * 	   接收返回的面积值并打印。
 * 3.3 修改上一个程序，在method方法提供m和n两个参数，方法中打印一个 m*n的*型矩形，
 * 	   并计算该矩形的面积， 将其作为方法返回值。在main方法中调用该方法，
 * 	   接收返回的面积值并打印。
 */


public class MatrixTest {
	public static void main(String[] args) {
		MatrixTest matrix1 = new MatrixTest();	//这里为什么是这样创建一个实例的？和之前其他的有什么不同吗？
		//不同是：下面创建的方法是在MatrixTest这个类下面的，我们没有另外再造一个类，但是它还是在一个类下面
		//所以不同直接调用这个方法，必须要先造一个实例
		matrix1.method1();
		int area = matrix1.method2();
		System.out.println(area);
		int area1 = matrix1.method3(12, 9);
		System.out.println(area1);
		
	}
	
	//3.1
	public void method1() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//3.2
	public int method2() {
		int area = 10*8;
		return area;
	}
	
	//3.3
	public int method3(int m, int n) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int area1 = m*n;
		return area1;
	}
}
```

#### StudentArray - 方法1 (所有操作都封装了)

```java
package com.hurjiang.exercise;

/**
 * 
 * @Description
 * @author hur
 * @version 2.0, 此版本是对1.0版本的改进，将操作都封装到方法中
 * @date 27.06.202221:03:28
 */
/*
 * 4. 对象数组题目: 定义类Student，包含三个属性:学号number(int)，年级state(int)，成绩 score(int)。 
 *    创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。 
 *    问题一:打印出3年级(state值为3)的学生信息。 
 *    问题二:使用冒泡排序按学生成绩排序，并遍历所有学生信息
 *    提示:
 *    1) 生成随机数:Math.random()，返回值类型double;
 *    2) 四舍五入取整:Math.round(double d)，返回值类型long。
 *  
 */

public class StudentArray1 {
	public static void main(String[] args) {
		
		Student0[] st = new Student0[20]; // String[] arr = new String[10];
		for(int i = 0; i < st.length; i++) {
			
			st[i] = new Student0();	//!!!!!!!!!!!!!!!
			
			// 学号
			st[i].number = (i + 1);
			//年级 [0, 6] 
			st[i].state = (int)(Math.random() * (6 - 1 + 1) + 1); 
			//成绩 [0, 100]
			st[i].score = (int)(Math.random() * (100 - 0 + 1) + 0);	
		}
		
		//在这个类下要创建一个新的对象
		StudentArray1 test = new StudentArray1();
		
		//遍历
		test.print(st);
		
		System.out.println("*********************************");
		
		//all state3 students
		System.out.println("All students who are from state 3: ");
		test.stateStudent(st, 3);
		
		//按成绩高低排序（冒泡排序）
		System.out.println("*********************************");
		test.sortBubble(st);
		
		//遍历查看新的排序过的顺序
		test.print(st);
	}
	
	/**
	 * 
	 * @Description 对数组进行遍历，并且输出每个数组元素的所有信息
	 * @author hur
	 * @date 27.06.202223:03:17
	 * @param stud 待遍历的数组
	 */
	//封装1：遍历
	public void print(Student0[] stud) {
		for(int i = 0; i < stud.length; i++) {
			stud[i].who();
		}
	}
	
	/**
	 * 
	 * @Description 查找Student数组中指定某个年级的学生信息
	 * @author hur
	 * @date 27.06.202223:00:29
	 * @param stud 查找范围的数组
	 * @param state 待查找的某个年级
	 */
	//封装2: state students
	public void stateStudent(Student0[] stud, int state) {
		int sum = 0;
		for(int i = 0; i < stud.length; i++) {
			if(stud[i].state == 3) {
				stud[i].who();
				sum++;
			}
		}
		System.out.println("在" + state + "年级的学生人数为：" + sum);
	}
	
	
	/**
	 * 
	 * @Description 利用冒泡排序法对数组进行排序，排序依据是成绩从低往高排
	 * @author hur
	 * @date 27.06.202223:01:43
	 * @param stud 待排序的数组
	 */
	//封装3: sortBubble
	public void sortBubble(Student0[] stud) {
		System.out.println("排序之后的学生顺序：");
		for(int j = 0; j < stud.length - 1; j++) {
			for(int i = 0; i < stud.length - j - 1; i++) {
				if(stud[i].score > stud[i + 1].score) {
          Student0 temp = stud[i]; // !!!!!!!!!!!!!!
          stud[i] = stud[i + 1];
          stud[i + 1] = temp;
				}
			}
		}
	}
}

class Student0{
	int number; // 学号
	int state;	// 年级
	int score;	// 成绩
	
	public void who() {
		String stud = "number: " + number + ", state: " + state + ", score: " + score;
		System.out.println(stud);
	}
}
```

#### StudentArray - 方法2(所有操作都没有封装)

```java
package com.hurjiang.exercise;
/**
 * 
 * @Description
 * @author hur
 * @version 1.0
 * @date 27.06.202221:04:10
 */

public class StudentArray {
	public static void main(String[] args) {
		
//		for(int i = 1; i <= 20; i++) {
//			Student i = new Student();
//		}
		
		// 是把20个学生放在数组里面，也就是创建20个对象，将这20个对象放在一个数组里面
		// Student 是一种类，就和String是一种类一样
		// 数组就是存储同一类型的集合
		Student[] st = new Student[20]; // String[] arr = new String[10];
		for(int i = 0; i < st.length; i++) {
			
			//这句很关键，也不好理解 ！和二维数组的第二维数组初始化一样 
			// String[][] arr = new String[3][];
			// arr[i] = new String[i];
			//原本创建一个新的对象是这样的：Student stud = new Student();
			//右边没变，左边变了
			st[i] = new Student();	//!!!!!!!!!!!!!!!
			
			// 学号
			st[i].number = (i + 1);
			//年级 [0, 6] *Math.random(): (int)(Math.random()*(max-min+1)+1)
			st[i].state = (int)(Math.random() * (6 - 1 + 1) + 1); 
			//成绩 [0, 100]
			st[i].score = (int)(Math.random() * (100 - 0 + 1) + 0);	
		}
		
		//遍历
		for(int i = 0; i < st.length; i++) {
			st[i].who();
		}
		
		System.out.println("*********************************");
		
		//all state3 students
		System.out.println("All students who are from state 3: ");
		for(int i = 0; i < st.length; i++) {
			if(st[i].state == 3) {
				st[i].who();
			}
		}
		
		//按成绩高低排序（冒泡排序）
		System.out.println("*********************************");
		System.out.println("排序之后的学生顺序：");
		for(int j = 0; j < st.length - 1; j++) {
			for(int i = 0; i < st.length - j - 1; i++) {
				if(st[i].score > st[i + 1].score) {
				// 直接打印st[i] 的话会出来什么？ 是地址吗？
				// 下面这句相当重要且意义重大，Student就是一种类，像其他数据类型一样！
				// 所以可以将学生直接整体换来换去
				Student temp = st[i]; // !!!!!!!!!!!!!!
				st[i] = st[i + 1];
				st[i + 1] = temp;
				}
			}
		}
		
		//遍历
		for(int i = 0; i < st.length; i++) {
			st[i].who();
		}
	}
}

class Student{
	int number; // 学号
	int state;	// 年级
	int score;	// 成绩
	
	public void who() {
		String stud = "number: " + number + ", state: " + state + ", score: " + score;
		System.out.println(stud);
	}
}
```

***对象数组的内存分析**

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220628115919572.png" alt="image-20220628115919572" style="zoom:50%;" />

#### MyDate (birthday)

```java
package com.hurjiang.exercise;

/*
 * 声明一个日期类型MyDate:有属性:年year,月month，日day。
 * 创建2个日期 对象，分别赋值为:你的出生日期，你对象的出生日期，并显示信息
 */
public class MyDate {
	public static void main(String[] args) {
		//创建MyDate类型的数组
		birthday[] birth = new birthday[2];
		
		//创建两个对象（实例），并且存在数组中
		birth[0] = new birthday();
		birth[1] = new birthday();
		
		//为这两个对象的属性赋值
		birth[0].name = "H";
		birth[0].year = 1995;
		birth[0].month = 2;
		birth[0].day = 9;
		
		birth[1].name = "L";
		birth[1].year = 1995;
		birth[1].month = 11;
		birth[1].day = 27;
		
		//调用birthday类中的whenisdate功能，输出各自的生日日期
		birth[0].whenisdate();
		birth[1].whenisdate();
		
	}
}

class birthday{
	String name;
	int year;
	int month;
	int day;
	
	public void whenisdate() {
		System.out.println(name + "' brithday is: " + day + "." + month + "." + year);
	}
}
```

### Quiz2

1. 什么是面向对象的编程思想？

2. 你怎么理解面向对象中的类和对象？它们二者之间是什么关系？

   类是对一类事物的描述，是抽象的

   对象是实实在在存在的，在编程中new出来的东西，在内存中占用了一定的空间

3. 类和对象的创建和执行操作有哪三步？

4. 类的方法内是否可以定义变量？是否可以调用属性？是否可以定义方法？是否可以调用方法？（是是否是）

# 方法的拓展

### 方法的重载 overload

同一个类中，相同方法名，不同参数列表（参数个数或参数类型或参数顺序）

跟方法的权限修饰符，返回值类型，形参变量名，方法体 都没有关系

如何确定某一个指定的方法？ 先看方法名，再看参数列表

### 可变个数的形参

1. 书写格式：`public void show(String ... strs){}`
2. jdk5.0 新增的功能
3. 在jdk5.0之前，可变个数形参是用数组来保存的 `public void show(String[] strs){}`
4. 所以不能同时有上述两种可变个数形参的表示，这个并不构成重载
5. 当调用可变个数形参的方法时，传入的参数个数可以是0，1，2，....
6.  可变个数形参在方法的形参中必须声明在末尾 `public void show(int i, String ... strs){}`, 里面的两个形参位置不能换

​		为什么只能写在后面？如果放在前面，传入值的时候就不知道可变形参个数是几个

7. 可变个数形参的方法中最多只能有一个可变形参

### 方法参数的值传递机制（重难点）

#### 关于变量的赋值

如果变量是基本数据类型，此时赋值的是变量所保存的数据值

如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值

#### 方法的形参的传递机制（值传递）

1.  形参：方法定义时，声明的小括号内的参数

​		实参：方法调用时，实际传递给形参的数据

2. 值传递机制

   2.1 对于基本数据类型而言， 实参赋值给形参的是真实存储的数据值而不是地址值

   ```java
   main(){
     int m = 10;
     int n = 20;
     v.swap(m,n);
     sysout(m,n); //	这里输出的结果没有交换，为什么？
     						 // 因为
   }
   
   swap(int m, int n){
     int temp = m;
     m = n;
     n = temp;
     sysout(m,n); // 这里输出的结果是交换了
   }
   ```

   <img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220628163055167.png" alt="image-20220628163055167" style="zoom:40%;" />

​	2.2 对于引用数据类型而言，实参赋值给形参的是地址值而不是真实存储的数据值

​	<img src="/Users/hurjiang/Desktop/Bildschirmfoto 2022-06-29 um 12.16.39.png" alt="Bildschirmfoto 2022-06-29 um 12.16.39" style="zoom:50%;" />

​	上述的例子既有基本数据类型，也有引用数据类型

​	此例的内存解析详见 NT>Java>值传递or参数传递机制

#### Quiz 6

```java
package com.hurjiang.exercise;

/*
 * (1)定义一个Circle类，包含一个double型的radius属性代表圆的半径，一个 findArea()方法返回圆的面s积。 
 * (2)定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义 如下:public void printAreas(Circle c, int times) 
 *    在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。 例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
 * (3)在main方法中调用printAreas()方法，调 用完毕后输出当前半径值。程序运行结果如图 所示。
 */

public class Ex6Circle {
	
	double radius;
	
	public double findArea() {
		return Math.PI * radius *radius;
	}
}

/*
 * (2)定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义 如下:public void printAreas(Circle c, int times) 
 *    在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。 例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
 */
public class Ex6PassObject {
	
	public void printAreas(Ex6Circle c, int times) {
		for(int i = 1; i <= times; i++) {
			c.radius = i;
			System.out.println("radius: " + c.radius + ", area: " + c.findArea()); 
		}
		c.radius = times + 1; //为什么在这个类中的方法改动radius，Test中main方法创建的类的radius也会改？
	}
}

//main 方法 Test
public class Ex6Test {
	public static void main(String[] args) {
		
		Ex6Circle c = new Ex6Circle();
		Ex6PassObject test = new Ex6PassObject();
		
		test.printAreas(c, 6);
		
		System.out.println("now radius is: " + c.radius);
	}
}	

```

### Quiz

1. 什么是方法的重载？

2. Java方法中的参数传递机制的具体体现？

   基本数据类型：数据值

   引用数据类型：地址值（含变量的数据类型）

   ```java
   Person p1 = new Person();
   User u1 = p1; 
   --> 编译错误
   // p1是Person类型的，u1是User类型的，类型不同且这里没有自动类型提升，所以不能赋值
   ```

3. 成员变量和局部变量在声明的位置上，在是否有默认初始化值上，在是否能有权限修饰符修饰上，在内存分配的位置上有何不同？

4. return关键字的作用

   4.1 结束方法

   4.2 对有返回值的方法可以有返回值

5. 内存结构：栈（存放局部变量）、堆（存放new出来的结构：对象、数组）

   变量：成员变量 vs 局部变量 （方法内、方法形参、构造器内、构造器形参、代码块内

# 4 Feature 1: Encapsulation and Hidding

### Key points

- private: child class has all attributes and methods of super class (include private), but child class doesn't have access to the private attributes and methods
- extension: child class can have its own attributes and methods, which means it can be extended 
- 

### 封装性的体现

之一: 将类的属性xxx私有化（private），同时提供公共（public）的方法去获取（getXxx）和设置（setXxx）

之二：不对外暴露的私有的方法， 之三：单例模式， 。。。。。。。

"high cohesion, low coupling" --> “高内聚，低耦合”

隐藏对象内部的复杂性，只对外公开简单的接口

**把该隐藏的隐藏起来，把该暴露的暴露出来**

### 封装性的体现需要权限修饰符来配合

1. Java规定的四种权限（从小到大）：private --> default(缺省) --> protected --> public

​	<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220629182415595.png" alt="image-20220629182415595" style="zoom:40%;" />

 2. 四种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类

    修饰类只能使用default和public

### 封装性总结

Java提供了四种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小

### Quiz

```java
************************ EncapsulationPerson ************************
package com.hurjiang.exercise;

/*
 * 创建程序,在其中定义两个类:Person和PersonTest类。定义如下:
 * 用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。 
 * 在PersonTest类中实例化Person类的对象b，调用setAge()和 getAge()方法，体会Java的封装性。
 */

public class EncapsulationPerson {
	
	private int age; // private权限：只能在当前类中使用
	
	public void setAge(int a) {
		if(a < 0 || a > 130) {
			// throw new RuntimeException("wrong data!");
			System.out.println("Wrong income data!");
			return; // 请问这里的return是什么功能
		}
		age = a;
	}
	
	public int getAge() {
		return age;
	}
}

************************ EncapsulationPersonTest ************************
package com.hurjiang.exercise;

/*
 * 在PersonTest类中实例化Person类的对象b，调用setAge()和getAge()方法，体会Java的封装性
 */
public class EncapsulationPersonTest {
	
	public static void main(String[] args) {
		
		EncapsulationPerson p1 = new EncapsulationPerson();
		// p1.age = 1;	//The field EncapsulationPerson.age is not visible
		p1.setAge(2);
		System.out.println("age is: " + p1.getAge());
	}
}
```

# 4 Feature 2: Inheritance

### 继承的好处

1. 减少代码的冗余
2. 便于功能的扩展
3. 为之后多态性的使用提供了前提

### 继承的格式

class A extends B{ }

A: 子类、派生类、subclass

B：父类、超类、基类、superclass

体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有属性和方法。特别的，父类声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构。只有因为封装性的影响，使得子类不能直接调用父类的结构而已。**注意！继承性和封装性之间并不会互相矛盾的！！！**

子类继承父类以后，还可以声明自己特有的属性方法，从而实现功能的拓展

但是，子类和父类的关系不同于子集和集合的关系

###  Java中关于继承性的规定

一个类可以被多个子类继承

一个类最多只能有一个父类（单继承）

子父类是相对的概念

直接父类，间接父类

子类继承父类后，就获取了直接父类和所有间接父类的属性和方法

### 默认继承 Object类

如果没有显式地声明一个类的父类，那就是默认继承java.lang.Object类

所有的java类（除java.lang.Object类之外）都直接或间接继承于java.lang.Object类

所有java类都具有java.lang.Object类声明的功能

### Quiz - Day11

### Quiz - inheritance

# 4 Feature 3: Polymorphism

## what 

"poly" = many, "morph" = form

多态性针对的是方法？

1. 什么是多态？a single reference type can refer to objects of multiple actual types in a class hierarchy

2. 对象的多态性：父类的引用指向子类的对象  parent type can reference a child object

​	`Person p = new Man();` 左边是父类的引用，多态性就是体现在右边的子类对象上

3. 多态的使用（应用）：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 -- **虚拟方法调用** 

有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法

**总结：编译看左边，运行看右边** 

```java
class Person{
  eat(){
    syso("People can eat.");
  }
  walk(){
    syso("People can walk.");
  }
}

class Man extends Person{
  eat(){
    syso("Man can eat a lot.");
  }
  walk(){
    syso("Man can walk more.");
  }
  earnMoney(){
    syso("Man can earn money.");
  }
}

Person p1 = new Man();
p1.eat();	//编译时通过的是Person类中eat方法，运行时是执行Man类中的eat方法
p1.walk();//编译时通过的是Person类中walk方法，运行时是执行Man类中的walk方法
p1.earnMoney(); //无法通过编译，原因是：编译时要看父类，然而父类Person中没有earnMoney方法

```

4. 多态的前提：

   a. 类的继承关系

   b. 方法的重写 (记住**方法重写的规则**)

5. 对象的多态性 **只适用于方法，不适用于属性**

```java
package com.hurjiang.poly;

public class AnimalTest {
	
	public static void main(String[] args) {
		
		AnimalTest test = new AnimalTest();
		test.function(new Dog());	// anonymous object new Dog()
    // --> Animal animal = new Dog(); test.function(animal)
	}
	
	public void function(Animal animal) {	// Animal animal = new Dog();
	// 注意这里，传进去的参数是Animal类型的，所以如果没有多态性，那就只能new一个Animal类型的参数
	// 但是我们在上面传了 Dog 类型的参数进去，为什么可以这样做呢？
	// 因为多态性，Dog是Animal的子类，并且Dog重写了Animal的方法
	// 这样很好得体现了多态性的优点，若是没有多态性，那这里就需要为Dog再造一个方法，为Cat再造一个方法，每一个都需要重新造方法
	// 
		animal.eat();
		animal.shout();
	}
}


class Animal{
	public void eat() {
		System.out.println("进食：");
	}
	public void shout() {
		System.out.println("大叫：");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("进食：骨头");
	}
	public void shout() {
		System.out.println("大叫：汪汪");
	}
}

class Cat extends Animal{
	public void eat() {
		System.out.println("进食：鱼");
	}
	public void shout() {
		System.out.println("大叫：喵喵");
	}
}
```

## static and dynamic

- compile-time polymorphism --> static

  - how: through method overloading (in same class, same method with different parameter lists)

  ```java
  class Calculator {
    int add (int a, int b) {
      return a+b;
    }
    double add (double a, double b) {
      return a+b;
    }
    int add (int a, int b, int c) {
      return a+b+c;
    }
  }
  
  Calculator calc = new Calculator();
  calc.add(5,10);
  calc.add(5.5, 2.2);
  calc.add(2,3,4);
  ```

  

- runtime polymorphism --> dynamic

  - how: through method overrding and inheritance
  - 

## 编译时行为和运行时行为

问：多态是编译时行为还是运行时行为？**运行时行为**

如何证明？见InterviewTest(com.hurjiang.polytest)

### 虚拟方法调用 virtual method invocation（多态情况之下）

当子类中定义了与父类同名同参数的方法，在多态的情况（继承，重写）下，将此时父类的方法称为虚拟方法，父类根据赋给它的不同子类对象，动态调用属于子类的该方法，这被称为虚拟方法调用，这样的方法调用在编译期是无法确定的

这个过程也称为**动态绑定**

## 静态绑定？动态绑定？

早绑定？晚绑定？

## Quiz - 多态性

### Quiz1

1. 若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，系统将不可能把父类里的方法转移到子类中：比编译看左边，运行看右边 
2. 对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，这个实例变量依然不可能覆盖父类中定义的实例变量：编译运行都看左边 （其实就是在说属性）

```java
class Base {
	int count = 10;
	public void display() { 
  	System.out.println(this.count);	// --> 10
	}
}

class Sub extends Base { 
  int count = 20;
	public void display() { 
    System.out.println(this.count);	// --> 20
	}
}

public class FieldMethodTest {
	public static void main(String[] args){
    Sub s = new Sub(); 
    System.out.println(s.count); // --> 20
    s.display();	// --> 20
		Base b = s; // 向上转型（多态）
    System.out.println(b == s);  // true
    System.out.println(b.count);  // 10，多态性只对方法，不对属性
    b.display();	// 20，这里调用的是子类的方法display，为什么？因为多态
	}
}
```

### Quiz2

```java
package com.hurjiang.instanceoftest2;

/*
 * 建立InstanceTest 类，在类中定义方法 method(Person e);
 * 在method中: 
 * (1)根据e的类型调用相应类的getInfo()方法。 
 * (2)根据e的类型执行: 如果e为Person类的对象，输出: “a person”; 
 * 如果e为Student类的对象，输出: “a student” “a person ” 
 * 如果e为Graduate类的对象，输出: “a graduated student” “a student” “a person”
 */

public class InstanceTest2 {

	public static void main(String[] args) {
		
		InstanceTest2 test = new InstanceTest2();
		
		Person p = new Person();
		Student s = new Student();
		
		test.method(new Student()); // 输出的是Student类的信息,体现了多态
		
	}
	
	public void method(Person e) {
		
		//1.
		System.out.println(e.getInfo());
		
		//2.
		if(e instanceof Graduate) {
			System.out.println("a graduated student");
			System.out.println("a student");
			System.out.println("a person");
		}else if(e instanceof Student) {
			System.out.println("a student");
			System.out.println("a perosn");
		}else {
			System.out.println("a person");
		}
	}	
}

class Person {
	
	protected String name="person";
	protected int age=50;
	public String getInfo(){
		return "Name: "+ name + "\n" +"age: "+ age;
	}
}

class Student extends Person{
	
	protected String school = "pku";
	public String getInfo() {
		return "Name: "+ name + "\nage: "+ age + "\nschool: "+ school;
	}
}

class Graduate extends Student{
	
	public String major = "IT";
	public String getInfo() {
		return "Name: "+ name + "\nage: "+ age + "\nschool: "+ school+"\nmajor:"+major;
	}
}
```

### Quiz3

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220707165436742.png" alt="image-20220707165436742" style="zoom:30%;" />

​	Code: OOP2 > com.hurjiang.polyquiz3

### InterviewQuiz1

```java
package com.hurjiang.polyinterviewquiz;

import java.util.Random;

//面试题：多态是编译时行为还是运行时行为？
//证明如下：
class Animal  {
 
	protected void eat() {
		System.out.println("animal eat food");
	}
}

class Cat  extends Animal  {
 
	protected void eat() {
		System.out.println("cat eat fish");
	}
}

class Dog  extends Animal  {
 
	public void eat() {
		System.out.println("Dog eat bone");

	}

}

class Sheep  extends Animal  {
 

	public void eat() {
		System.out.println("Sheep eat grass");

	}

 
}

public class InterviewTest {

	public static Animal  getInstance(int key) {
		switch (key) {
		case 0:
			return new Cat ();
		case 1:
			return new Dog ();
		default:
			return new Sheep ();
		}

	}

public static void main(String[] args) { 
	
		int key = new Random().nextInt(3);

		System.out.println(key);

		Animal  animal = getInstance(key);
		
		animal.eat();
		 
	}

}
```

### InterviewQuiz2

```java
package com.hurjiang.polyinterviewquiz;
//考查多态的笔试题目：
public class InterviewTest1 {

	public static void main(String[] args) {
		Base base = new Sub();
		base.add(1, 2, 3);	// 这个运行的结果是什么？为什么？
    // 结果是sub_1
    // public void add(int a, int... arr)，public void add(int a, int[] arr) 这两个形参列表被认为是相同的，所以它们属于方法的重写，也就是多态的应用了，这个时候子类的方法会被调用
    // public void add(int a, int b, int c) 而这个的形参列表和其它两个父类的形参列表并不一样，所以这不是方法的重写，如果不是重写，那就是调用父类的方法
    // 所综合来看，就是调用Sub类中的方法，故输出 "sub_1"

		Sub s = (Sub)base; 
		s.add(1,2,3);	// 那这个的结果是什么？ sub_2
    // 这样就是要看是要调Sub中两个方法中的哪一个了？
    // 就是调用第二个，因为第一个方法是不确定形参个数的，基本原则是要先调确定参数的方法
	}
}

class Base {
	public void add(int a, int... arr) {
		System.out.println("base");
	}
}

class Sub extends Base {

	public void add(int a, int[] arr) {
		System.out.println("sub_1");
	}

	public void add(int a, int b, int c) {
		System.out.println("sub_2");
	}

}
```

# Overloading and Overriding

>https://javaguide.cn/java/basis/java-basic-questions-01.html#重载和重写有什么区别

|           | overloading         | overriding                                                   |
| --------- | ------------------- | ------------------------------------------------------------ |
| where     | same class          | in child class                                               |
| parameter | have to change      | can't change                                                 |
| return    | changable           | return type shoul be at least same or smaller than in super class |
| exception | changable           | exception class have to be at least same or smaller than in super class |
| modifier  | changable           | can't raise up the limitation (you can make it lower)        |
| when      | during compile time | during runing time                                           |

## Overloading

同一个类中，相同方法名，不同参数列表（参数个数或参数类型或参数顺序）

跟方法的权限修饰符，返回值类型，形参变量名，方法体 都没有关系

如何确定某一个指定的方法？ 先看方法名，再看参数列表

## Overriding

- child class overwrite the method in super class
- 方法的声明： 权限修饰符 返回值类型 方法名（形参列表） throws 异常类型
  - 重写的方法和被重写的方法必须**同名同形参列表**
  - 重写的方法的权限修饰符不小于被重写的方法的权限修饰符
    但是，private权限的方法是不能被子类重写的，此时，如果在子类中写同方法名和形参列表的方法是可以的，但是就不认为是重写了
    因为private的方法在父类中对于子类而言是看不到的，是隐藏的
  - 返回值类型 
    - 父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
    - 父类被重写的方法的返回值类型是A类型（引用数据类型），则子类重写的方法的返回值类型可以是A类型或A类型的子类
    - 父类被重写的方法的返回值类型是基本数据类型，则子类重写的方法的返回值类型只能是相同的基本数据类型
  - 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型

****

子类和父类中的同名同形参列表的方法要么都声明为非static(可以重写)，要么都声明为static(不能重写)



# instanceof 操作符

有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但是由于变量声明为父类类型，导致编译时，只能调用父类中声明的属性和方法，子类特有的的属性和方法不能调用

那么如何才能调用子类特有的属性和方法？向下转型 （强制类型转换）；向上转型（多态）

a instanceof A: 判断对象a是否是类A的实例。如果是，返回true，如果不是，返回false

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220707140318931.png" alt="image-20220707140318931" style="zoom:30%;" />

```java
package com.hurjiang.instanceoftest;

public class InstanceTest {
	
	public static void main(String[] args) {
		
		Person p1 = new Man();	//多态性
		Person p2 = new Man();
		
		p1.age = 1;
		p1.name = "jj";
		System.out.println(p1.id);	//1001, why?
		
//		p1.isSmoking = true;	// 为什么调不了Man的属性
		
//		p1.earnMoney();	// 为什么调不了Man的方法
		// 因为变量声明的时候 Person p1 是父类类型，所以当我们编译时，只能调用父类中声明的属性和方法。
		// 子类特有的属性和方法不能调用
		// 那么如何才能调用子类特有的属性和方法呢？ 把变量声明的类型从父类改为子类，怎么改呢？
		// 注意：若是从子类到父类，可以直接赋值，这叫多态；但是从父类到子类，需要“强制类型转换”
		Man m1 = (Man) p1;	// 这叫向下转型，属于多态性，所以通常不会说向下或向上转型，只说多态
		// p1的值是一个地址值 "___@_____"，@前面是类型，@后面是地址值，若是不加（Man）直接赋值，
		// 因为p1和m1的类型不同，就没法赋值
		m1.earnMoney();
		m1.isSmoking = true;
		
		// 但是上面的这种强型转换是有风险的，就如同对基本数据类型的强型转换会失去精度一样
		// 使用强转时，可能出现ClassCastException的异常
		// 为了避免这个异常，我们在向下转型之前，先进行instanceof的判断，一旦返回true，就进行向下转型，如果返回false，不进行向下转型
		// instanceof: a instanceof A, 判断对象a是否是类A的实例，是，返回true，不是返回false
		boolean isType = p2 instanceof Man;	// 为什么p2没有经过强转也算是Man的实例呢？
		System.out.println(isType);
		
		// Quiz(Test)
		// Q1: 编译通过，运行不过
		Person p3 = new Woman();
		Man m3 = (Man) p3;	//这里编译能过的原因是编译时p3被编译器认为是Person类的
		
		// Q2: 编译通过，运行也通过
		Object obj = new Woman();
		Person p = (Person) obj;
		
		// Q3: 编译不通过
//		Man  m4 = new Woman();	//这个编译肯定过不了
//		String str = new Date();
	}
}
```


# Class member 3: constructor

任何一个类都有构造器

### 构造器的作用

1. 创建对象：`Person p = new Person();` --> Person() is constructor

2. 初始化对象的信息

### 构造器说明

1. 如果没有显示的定义类的构造器，默认有一个空参的构造器

2. 构造器的定义格式：权限修饰符 类名(形参列表){ }
3. 一个类中定义的多个构造器构成重载（因为构造器的名字和类名相同，所以在同一个类中的构造器一定是同名，就会出现重载）
4. 只要人为定义一个构造器，系统就不再默认提供空参构造器
5. 一个类中至少有一个构造器

```java
public class PersonTest{
  public static main void(String[] args){
    Person p1 = new Person();
    Person p2 = new Person("T");
  } 
}

class Person{
  //field
  String name;
  int age;
  
  //constructor
  public Person(){ //权限修饰符 类名(形参列表){}
    System.out.println("Person()...");
  }
  public Person(String n, int a){ //如果把这个构造器去掉，创建p1对象就会报错
    name = n;
    age = a;
  }
  //上述这些构造器之间也叫作重载，和方法的重载类似
  
  //method
  public void eat(){
    System.out.println("i eat!");
  }
  public void study(){
    System.out.println("i study!");
  }
}
```

### Quiz

1. Person

```java
package com.hurjiang.exercise;

/*
 * 1. 在前面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18。
 * 2. 修改上题中类和构造器，增加name属性,使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
 */
public class ConstructorPersonTest {
	
	public static void main(String[] args) {
		
		ConstructorPerson p1 = new ConstructorPerson();
		// System.out.println(p1.name); // The field ConstructorPerson.name is not visible
		System.out.println("my name is: " + p1.getName() + ", i'm " + p1.getAge() + " years old.");
	}
}

class ConstructorPerson{
	
	//field
	private String name;
	private int age;
	
	//constructor
	public ConstructorPerson() {
		age = 18;
		name = "Jiang";
	}
	public ConstructorPerson(int b, String n) {
		age = b;
		name = n;
	}
	
	//method(for encapsulation)
	public void setAge(int a) {
		if(a < 0) {
			age = -1;
		}else {
			age = a;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}
```

2. TriAngle

```java
package com.hurjiang.exercise;

/*
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长base和高height，同时声明公共方法访问私有变量。
 * 此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 * 
 */

************************ ConstructorTriAngle ************************
public class ConstructorTriAngle {
	
	//field
	private double base;
	private double height;
	
	public void setData(double b, double h) {
		base = b;
		height = h;
	}
	
	//constructor
	public ConstructorTriAngle() {
		base = 3.2;
		height = 2.0;
	}
	public ConstructorTriAngle(double b, double h) {
		base = b;
		height = h;
	}
	
	//method
	public double getBase() {
		return base;
	}
	public void setBase(double b) {
		base = b;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double h) {
		height = h;
	}
	public double getArea() {
		double area = base * height / 2;
		return area;
	}
}

************************ ConstructorTriAngleTest ************************

/*
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底 边长base和高height，同时声明公共方法访问私有变量。
 * 此外，提供类 必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 * 
 */

public class ConstructorTriAngleTest {
	
	public static void main(String[] args) {
		
		ConstructorTriAngle t = new ConstructorTriAngle();
		
		// t.base = 2.0;  // The field ConstructorTriAngle.base is not visible
		// t.height = 1.2; //The field ConstructorTriAngle.base is not visible
		
		System.out.println("area: " + t.getArea());
		
		ConstructorTriAngle t1 = new ConstructorTriAngle(5.0, 2.4);
		t1.setData(4.0, 6.8);
		System.out.println("area: " + t1.getArea());
		
	}
}
```

### 总结属性赋值的先后顺序

从前往后：默认初始化值 < 显式初始化 < 构造器中初始化 < “对象.方法”或“对象.属性”

默认初始化值，显式初始化，构造器中初始化 这三个方式是在对象（实例）“出生”之前就定义了，因为是定义在类中，所以每个新的对象“出生”的时候就被初始化了，这三个初始化对每一个对象而言只会被操作一次

而对象.方法或对象.属性是可以重复调用的



# Class member 4: block

1. 代码块的作用：初始化类、对象
2. 代码块如果有修饰，只能使用static
3. 分类：静态代码块 vs 非静态代码块
4. 静态代码块
   - 内部可以输出语句
   - 随着类的加载而执行，而且只执行一次
   - 作用：初始化类的信息
   - 如果有多个静态代码块，则按照声明的先后顺序执行
   - 静态代码块的执行要优先于非静态代码块的执行
   - 静态代码块内只能调用静态的属性、方法，不能调用非静态的结构
5. 非静态代码块
   - 内部可以有输出语句
   - 随着对象的创建而执行，并且每创建一个对象，就执行一次非静态代码块
   - 作用：可以在创建对象时，对对象的属性等进行初始化
   - 如果有多个非静态代码块，则按照声明的先后顺序执行
   - 非静态代码块内可以调用静态的属性、方法，和非静态的属性、方法

```java
package com.hurjiang.block;

public class BlockTest {
	
	public static void main(String[] args) {
		
		String desc = Person.desc;
		
		Person p1 = new Person();
	}
}

class Person {
	
	//fields
	String name;
	int age;
	static String desc = "我是一个人";
	
	//constructor
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//static block
	static {
		System.out.println("this is static block-1.");
		desc = "wo shi ai xue xi de ren";
	}
	static{
		System.out.println("this is static block-2.");
	}
	
	//block
	{
		System.out.println("this is block.");
		age = 1;
	}
	
	//method
	public void eat() {
		System.out.println("吃");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public static void info() {
		System.out.println("wo shi zi ge kuai le de ren");
	}	
}
```

### 对属性赋值的先后顺序

对属性可以赋值的位置：1. 默认初始化 2. 显式初始化 3. 构造器中初始化 4. 有了对象后，通过“对象.属性”或“对象.方法”的方式进行赋值 5. 在代码块中赋值

执行的先后顺序：1 --> 2/5 --> 3 --> 4 

### Quiz1

```java
public class Something {
    public int addOne(final int x) {
      return ++x;	//-->编译失败 x++: x=x+1，x不能被修改
			// return x + 1; --> 成功，因为x+1后没有再赋给x了
    } 
}
```

### Quiz2

```java
public class Something {
    public static void main(String[] args) {
			Other o = new Other();
			new Something().addOne(o); 
    }
	public void addOne(final Other o) { 
    // o = new Other(); // 失败
		o.i++; //成功
	} 
}
class Other { 
  public int i;
}
```

# Class member 5: InnerClass

1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类

2. 内部类的分类：成员内部类（静态和非静态） vs 局部内部类（方法内，代码块内，构造器内）

3. 成员内部类：

   首先是一个类：

   - 类内可以定义属性、方法、构造器等

   - 可以被final修饰，表示此类不能被继承。言外之意，若是不使用final，就可以被继承

   - 可以被abstract修饰

   其次又是外部类的成员：

   - 调用外部类的成员
   - 可以被static修饰
   - 可以被4种不同的权限修饰 

4. 三个问题：

   1. 如何实例化成员内部类的对象
   2. 如何在成员内部类中区分调用外部类的结构（尤其是重名的时候）
   3. 开发中局部内部类的使用，见 OOP3 -> com.hurjiang.innerclass -> InnerClassTest2

# Keyword

## keyword: this

1. 

this用来修饰属性，此时this表示当前对象：this.field

this用来修饰方法: this.method

对于上述两种情况而言，this就是类中定义时出现同名就需要加上，默认不加（但是个人觉得为啥不直接加上呢）

2. this用来修饰构造器

​		我们在类的构造器中，可以是显式地使用 “this(形参列表)" 的方式来调用本类中指定的其它构造器

​		构造器中不能通过“this(形参列表)”的方式来调用自己

​		构造器之间不能互调，只能有一个方向的调用

​		构造器的调用必须在首行

​		一个构造器只能调用另一个构造器，不能同时调用两个及以上

```java
public class Person{
  private int id;
  private String name;
  
  public Person(){ //constructor1
    this.eat();
    ...(40行代码)
  }
  public Person(String name){ //constructor2
    this(); //调用了上面的
    this.name = name;
  }
  public Person(int id){ //constructor3
    this();
    this.id = id;
  }
  public Person(String name, int id){ //constructor4
    this(id);
    this.name = name;
  }
  
  public void setId(int id){
    this.id = id;
  }
  public int getId(){
    return id;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
}
```

## keyword: package

1. 用来管理
2. 声明在首行
3. 遵循标识符规则
4. 一个"."就是一级文件目录

## keyword: import

1. 在源文件中使用import显式的导入指定包下的类或接口

2. 声明在包的声明和类的声明之间。

3. 如果需要导入多个类或接口，那么就并列显式多个import语句即可

4. 举例:可以使用java.util.*的方式，一次性导入util包下所有的类或接口。

5. 如果导入的类或接口是java.lang包下的，或者是当前包下的，则可以省略此import语句。

6. 如果在代码中使用不同包下的同名的类。那么就需要使用类的全类名的方式指明调用的 是哪个类。

7. 如果已经导入java.a包下的类。那么如果需要使用a包的子包下的类的话，仍然需要导入。 8. import static组合的使用:调用指定类或接口下的静态的属性或方法





## keyword: final (Modifizier)

1. final deklariert Klassen, Methoden, Variablen

2. final deklariert Klasse: die Klasse就不能被其他类所继承（不能有子类）。比如：String类，System类，StringBuffer类

3. final用来修饰方法，表示此方法不能被重写。比如：Object类中getClass( )

4. final用来修饰变量：此时的“变量”就是一个常量

   - final修饰属性的时候，可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化

     问：为什么方法中初始化不行？

   - final修饰局部变量，变成常量。尤其是使用final修饰形参时，表明形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。

5. static final: 修饰属性 --> 全局常量

## keyword：static

1. static 可以用来修饰：属性，方法，代码块，内部类

2. 使用static修饰属性，这类属性称为静态变量（或类变量）

   2.1 按照是否使用static修饰，将属性分为：静态属性和非静态属性（实例变量）

   - 实例变量：变量属于实例。当我们创建同一个类的多个对象，每个对象都独立拥有一套类中的的非静态变量。当修改其中任意一个对象的非静态属性时，其他对象的相同属性并不会因此改变
   - 静态变量：变量属于类。同一个类的多个对象共享一个静态变量。当其中任意一个对象的静态变量被修改时，其他对象的静态变量也随之被修改

   2.2 static修饰属性时的其他说明

   - 静态变量随着类的加载而加载。可以通过“类.静态变量”的方式来调用

   - 静态变量的加载要早于对象的创建

   - 由于类只会加载一次，所以静态变量在内存中也只会存在一份，也就是在方法区的静态域中

   - 类和对象对类变量和实例变量的调用权限

     |      | 类变量 | 实例变量 |
     | ---- | ------ | -------- |
     | 类   | yes    | no       |
     | 对象 | yes    | yes      |

   2.3 静态属性的例子: System.out ;  Math.PI

   ​	   System和Math都是类，这里就是直接调用类的方法out和属性PI

3. static修饰方法：静态方法

   3.1 随着类的加载而加载，可以通过“类.静态方法”的方式来调用

   |      | 静态 | 非静态 |
   | ---- | ---- | ------ |
   | 类   | yes  | No     |
   | 对象 | yes  | yes    |

   3.2 

   - 静态方法中，只能调用静态的方法或属性
   - 非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
   - 理解：先有类再有对象，无论是属性还是方法，类的加载肯定是早于对象的，就是说肯定是先造了类，再造这个类的对象。那么，当类（静态结构）被造好后，对象（非静态结构）也许都还没造出来，那你怎么从类中调对象的属性或方法呢？或说你怎么从静态结构中调非静态结构呢？但是反过来，对象就既可以调对象的属性或方法，也能调类的属性或方法，也就是非静态结构可以调非静态结构的属性或方法，同时也可以调静态结构的属性或方法

4. static注意点：

   4.1 在静态的方法内，不能使用this关键字、super关键字

   4.2 静态结构与类同步，非静态结构与对象同步

5. 是否声明为static？

   - 在开发中，如何确定一个属性是否要声明为static？

     -1- 属性可以被多个对象所共享，并且不会随着对象的不同而不同的

     -2- 类中的常量也常常声明为static

   - 以及一个方法是否要声明为static？

     -1- 操作静态属性的方法，通常设置为static的

     -2- 工具类中的方法，习惯上声明为static的，比如：Math, Arrays, Collections...

### StaticQuiz

```java
package com.hurjiang.statictest;

/*
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密 码”、“存款余额”、“利率”、“最小余额”，定义封装这些 属性的方法。
 * 账号要自动生成。 编写主类，使用银行账户类，输入、输出3个储户的上述信息。 考虑:哪些属性可以设计成static属性
 */
public class Account {
	private int id;
	private String pw;
	private double balance;
	
	private static double interestRate;
	private static double minAmount;
	private static int init = 1001;	//用于自动生成id
	
	public Account() {
		id = init++;
	}
	public Account(String pw, double balance) {
		this();	// id = init++;
		this.pw = pw;
		this.balance = balance;
	}
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public static double getInterestRate() {
		return interestRate;
	}
	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}
	public static double getMinAmount() {
		return minAmount;
	}
	public static void setMinAmount(double minAmount) {
		Account.minAmount = minAmount;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", pw=" + pw + ", balance=" + balance + "]";
	}
}
```

```java
package com.hurjiang.statictest;

public class AccountTest {
	
	public static void main(String[] args) {
		
		Account a1 = new Account();
		Account a2 = new Account("qwertz", 2000);
		
		Account.setInterestRate(0.012);
		Account.setMinAmount(100);
		
		System.out.println(a1);	//--> Account [id=1001, pw=null, balance=0.0]
		System.out.println(a2);	//--> Account [id=1002, pw=qwertz, balance=2000.0]
		
		System.out.println(a1.getInterestRate());	//-->0.012
		System.out.println(a2.getInterestRate());	//-->0.012
	}
}
```

### StaticApplication - Singleton(单例设计模式)

设计模式：在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。“套路”

优点：由于单例模式只生成一个实例，**减少了系统性能开销**，当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决

所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。 

如果我们要让类在一个虚拟机中只能产生一个对象，我们**首先必须将类的构造器的访问权限设置为private**，这样，就不能用new操作符在类的外部产生类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象， 静态方法只能访问类中的静态成员变量，所以，指向类内部产生的该类对象的变量也必须定义成静态的。

1. 饿汉式：提前炒好，要吃就取（快餐）

   ```java
   package com.hurjiang.singleton;
   
   public class SingletonTest1 {
   	public static void main(String[] args) {
   		Bank bank1 = Bank.getInstance();
   		Bank bank2 = Bank.getInstance();
   		
   		System.out.println(bank1 == bank2);
   		
   	}
   }
   //饿汉式
   class Bank{
   	
   	//1.将类的构造器私有化,从而防止从类的外部新建对象
   	private Bank() {	
   	}
   	//2. 内部创建类的对象
   	private static Bank instance = new Bank();	// 4. 要求此对象也必须声明为静态的
   	
   	//3. 提供公共的方法，返回类的对象
   	public static Bank getInstance() {
   		return instance;
   	}	
   }
   ```

2. 懒汉式：现点现炒

   ```java
   package com.hurjiang.singleton;
   
   public class SingletonTest2 {
   }
   
   class Order{
   	
   	//1. 私有化类的构造器 --> 从而不能从类的外部新建对象
   	private Order() {
   	}
   	
   	//2. 在类中声明当前的类对象，但是和饿汉式不同的是，懒汉式没有初始化(其实这里类对象的声明就好像是定义了一个类的属性)
   	//4. 此对象也必须声明为static的
   	private static Order instance;
   	
   	//3. 声明public、static的返回当前类对象的方法(为什么需要返回的方法呢？因为上面的类对象被定义为了private)
   	public static Order getInstance() {
   		//但是只有当instance为null时，才会new一个新的对象赋值给instance
   		if(instance == null) {	// 为什么报错呢？因为静态方法调用的属性也要是静态的
   			instance = new Order();
   		}
   		return instance;
   	}	
   }
   ```

3. 饿汉式 vs. 懒汉式

   饿汉式：对象加载时间过长（缺），线程安全（优）

   懒汉式：延迟对象的创建（优），目前的写法是线程不安全的（缺）

## keywords: super

调用父类中被重写的方法

1. 父类的

2. super.属性/方法

3. super调用构造器

   a. 可以在子类的构造器中显式地使用“super(形参列表)”的方式，调用父类中声明的指定的构造器

   b. “super(形参列表)” 的使用，必须声明在子类构造器的首行

   c. 在类的构造器中，this(形参列表) or super(形参列表) 只能二选一，不能同时出现

   d. 在构造器的首行，没有显示的声明 this(形参列表) or super(形参列表)，则默认调用的是父类中空参的构造器 super()

   e. 在类的多个构造器中，至少有一个类的构造器中使用了 super(形参列表)，调用父类的构造器

4. 关于 super(...) and this(...) 的两个问题

   (1).为什么super(...)和this(...)调用语句不能同时在一个构造器中出现? 

   (2).为什么super(...)或this(...)调用语句只能作为构造器中的第一句出现?

5. 虽然创建子类对象时，调用了父类的构造器，但是自始自终就创建过一个对象，就是new的子类对象 



## Quiz - BoyGirl

```java
package com.hurjiang.exercise;

public class ThisQuizBoy {
	
	//field
	private String name;
	private int age;
	
	//constructor
	public ThisQuizBoy() { //constructor1
		
	}
	public ThisQuizBoy(String name) {	//constructor2
		this.name = name;
	}
	public ThisQuizBoy(String name, int age) {	//constructor3
		this.name = name;
		this.age = age;
	}

	//method get,set
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
	
	//method marry
	public void marry(ThisQuizGirl girl) {	//这里传入的形参是ThisQuizGirl类型的girl，为什么这里可以调用到其他的类呢？
										  	//因为ThisQuizGirl是public的权限，若是将其权限改为private，就马上会报错
		System.out.println("want to marry: " + girl.getName());
	}
	//method shout
	public void shout() {
		if(this.age >= 22) {
			System.out.println("marry!");
		}else {
			System.out.println("wait!");
		} 
	}
}
```

```java
package com.hurjiang.exercise;

public class ThisQuizGirl {
	
	private String name;
	private int age;
	
	//constructor
	public ThisQuizGirl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//method set,get 
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	//method marry
	public void marry(ThisQuizBoy boy) { //传入类型为ThisQuizBoy的形参boy
		System.out.println("wanna to marry to: " + boy.getName());
	}
	
	//method compare
	/**
	 * 
	 * @Description 比较两个对象的大小
	 * @author hur
	 * @date 30.06.202214:54:52
	 * @param girl
	 * @return 返回值为正数，则当前对象大；负数，当前对象小；0，二者相等
	 */
	public int compare(ThisQuizGirl girl) {
		if(this.age > girl.age) {	//who is this, who is girl?
			return 1;
		}else if(this.age < girl.age) {
			return -1;
		}else {
			return 0;
		}
		// return this.age - girl.age;
	}
}
```

```java
package com.hurjiang.exercise;

public class ThisQuizBoyGirlTest {
	public static void main(String[] args) {
		
		ThisQuizBoy boy = new ThisQuizBoy("J", 21);
		boy.shout();
		
		ThisQuizGirl girl = new ThisQuizGirl("L", 20);
		girl.marry(boy);
		
		ThisQuizGirl girl1 = new ThisQuizGirl("hh", 23);
		System.out.println(girl.compare(girl1)); // --> -1
	}
}
```

## Quiz - Experiment2



```java
```

7. 

## Quiz - Day9

1. 构造器的作用是什么？使用中有哪些注意点(>=3条)

​		①创建对象 ②初始化对象结构 

2. 关于类的属性的赋值，有几种赋值的方式。谈谈赋值的先后顺序

​		默认初始化-显式初始化-构造器中初始化-对象.方法 或 对象.属性 给属性赋值

3. this关键字可以用来调用哪些结构，简单说明一下其使用。

​		this:属性、方法、构造器

​		this:理解为当前对象，当前正在创建的对象

4. Java中目前学习涉及到的四种权限修饰符都有什么？并说明各自的权限范围

​		private int age;

​		private void eat(){}

5. 创建Circle类，提供私有的radius属性，提供相应的get和set方法，提供求圆面积的方法。





## Quiz day12

1. 什么是多态性？什么是虚拟方法调用？

​		对象的多态性：父类的引用指向子类的对象。

​		Person p = new Man();

​		p.eat();

​		调用方法时，编译时看左边，运行时看右边。

2. 一个类可以有几个直接父类？（只有一个）一个父类可有多少个子类？（多个）子类能获取直接父类的父类中的结构吗？（可以）子类能否获取父类中private权限的属性或方法？(可以的)

​		A is a B

3. 方法的重写(override/overwrite)的具体规则有哪些？

​		方法名、形参列表相同

​		权限修饰符

​		返回值

​		抛出的异常

4. super调用构造器，有哪些具体的注意点

​		this(形参列表)：本类重载的其它的构造器

​		super(形参列表):调用父类中指定的构造器

​		n n – 1 1 

5. 在下面的代码结构中：使用关键字：this,super;方法的重写;继承;

   <img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220705223922910.png" alt="image-20220705223922910" style="zoom:60%;" />

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220705223315764.png" alt="image-20220705223315764" style="zoom:60%;" />

6. 区分重写和重载

   a. 二者的概念

   b. 二者的具体规则

   c. 重载：不表现多态性；重写：表现了多态性

# 抽象类与抽象方法

抽象类是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类

abstract 关键字的使用

1. abstract可以用来修饰的结构：类、方法

2. abstract修饰类

   - 此类不能实例化
   - 抽象类中一定有构造器，便于子类实例化时调用
   - 开发中，都会提供抽象类的子类，让子类对象实例化

3. abstract修饰方法 --> 抽象方法

   - 抽象方法只有方法的声明，没有方法体

   - 包含抽象方法的类一定是抽象类，从而保证抽象方法不会被调用；反之，抽象类中不一定有抽象方法

   - 若子类重写了父类中的所有抽象方法后，此子类才可以实例化

     若子类没有重写父类中的所有抽象方法，那么此子类也是一个抽象类，需要使用abstract修饰

4. abstract使用时的注意点：

   - abstract不能用来修饰属性、构造器等结构

   - abstract不能修饰private方法、static方法、final的方法、final的类

问题1:为什么抽象类不可以使用final关键字声明? 

答：抽象类肯定有子类，而final一定没有子类

问题2:一个抽象类中可以定义构造器吗?

答：可以，并且是一定有，便于子类实例化时调用

问题3:是否可以这样理解:抽象类就是比普通类多定义了抽象方法，除了不能直接进行类的实例化操作之外，并没有任何的不同?

答：听说是的......

### Quiz

```java
package com.hurjiang.abstracttest;

/*
 * 编写一个Employee类，声明为抽象类， 包含如下三个属性: name，id，salary。 
 * 提供必要的构造器和抽象方法:work()。 
 * 对于Manager类来说，他既是员工，还具有奖金(bonus)的属性。
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类 中提供必要的方法进行属性访问。
 */



public abstract class Employee{
	
	private String name;
	private int id;
	private double salary;
	
	public Employee() {
		super();
	}
	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract void work();
}

```

```java
package com.hurjiang.abstracttest;

public class Manager extends Employee{	//所以子类不一定是抽象类？ 只要重写父类的抽象方法就可以？为什么呢？
	
	private double bonus;

	public Manager(double bonus) {
		super();
		this.bonus = bonus;
	}
	public Manager(String name, int id, double salary, double bonus) {
		super(name, id, salary);
		this.bonus = bonus;
	}
	
	@Override
	public void work() {
		System.out.println("管理员工，提高公司运行效率");
	}
}
```

```java
package com.hurjiang.abstracttest;

public class CommonEmployee extends Employee{
	
	public void work() {
		System.out.println("员工在一线车间生产产品");
	}
}
```

```java
package com.hurjiang.abstracttest;

public class EmployeeTest {
	public static void main(String[] args) {
		
		Manager manager = new Manager("kuke",1001,5000,20000);
		// Employee manager = new Manager(); 多态
		manager.work();
		
		Employee commonEmployee = new CommonEmployee();	// 多态
		commonEmployee.work();		
	}
}
```

### AnonymousClass (匿名类)

```java
package AnonymousClass;

// 匿名类

public class PersonTest {
	
	public static void main(String[] args) {
		
//		Person p1 = new Person(); // 抽象类不可以实例化
		
		//创建一个匿名对象p2 （可以理解为是Person类的一个子类，并且用了多态赋给Preson类的p2）
		Person p2 = new Person() {	//后面的Person可以理解为Person的一个子类

			@Override
			public void eat() {
				System.out.println("eat");				
			}
			@Override
			public void breath() {
				System.out.println("breath");	
			}
		};
		
		method1(p2); //method1是静态方法，所以这里不需要通过对象来调。
		// 为什么p2可以作为形参传进来呢？
		// 因为p2是一个Person类子类的匿名对象
		
		method1(new Person() {	//匿名对象的匿名类
			@Override
			public void eat() {
				System.out.println("多吃点");
			}
			@Override
			public void breath() {
				System.out.println("好好呼吸");	
			}
		});
		
	}
	public static void method1(Person p) {	//静态方法method1，形参为Person类的p
		p.eat();
		p.breath();
	}
}
```

### TemplateMethod (模版方法设计模式) 

```java
package com.hurjiang.templatemethod;

public class TemplateTest {
	
	public static void main(String[] args) {
		
		Template t = new SubTemplate();
		t.spendTime();
	}
	
}

abstract class Template{
	
	//计算某段代码执行所需的时间
	public void spendTime() {
		
		long start = System.currentTimeMillis();
		
		code();	//不确定的部分、易变的部分
		
		long end = System.currentTimeMillis();
		
		System.out.println("spent time: " + (end - start));
	}
	
	public abstract void code(); // why abstract?
}

class SubTemplate extends Template{

	@Override
	public void code() {
		
		for(int i = 2; i <= 1000; i++) {
			boolean isFlag = true;
			for(int j = 2; j <= Math.sqrt(i);j++) {
				if(i % j == 0) {
					isFlag = false;
					break;
				}
			}
			if(isFlag) {
				System.out.println(i);
			}
		}
	}	
}
```

### Quiz - SalarySystem

见：OOP3 -> com.hurjiang.salarysystem 

![image-20220720094404724](/Users/hurjiang/Library/Application Support/typora-user-images/image-20220720094404724.png)

# Interface

### 接口的使用

1. 用interface关键字来定义

2. Java中，接口和类是并列的两个结构

3. 如何定义接口和接口中的成员？

   - JDK7及以前，只能定义全局常量和抽象方法

     全局常量：public static final (但是书写时，可以不写)

     抽象方法：public abstract


   - JDK8开始，除了可以定义全局常量和抽象方法之外，还可以定义静态方法、默认方法

     静态方法: 使用 static 关键字修饰。**可以并且只能通过接口直接调用静态方法，并执行其方法体**。我们经常在相互一起使用的类中使用静态方法。你可以在标准库中 找到像Collection/Collections或者Path/Paths这样成对的接口和类。

     默认方法: 默认方法使用 default 关键字修饰。**可以通过实现类对象来调用**。 我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。 比如:java 8 API中对Collection、List、Comparator等接口提供了丰富的默认 方法。

     -> OOP3 -> com.hurjiang.interfacejava8 -> HelpWMF.java

4. 接口中不能定义构造器，这意味着接口不能实例化

5. Java开发中，接口通过类去实现(implements)的方式来使用 - 类实现接口

6. 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化

   如果实现类没有覆盖接口中的所有抽象方法，则此实现类就不可以实例化

   ```java
   package com.hurjiang.interfacetest;
   
   public class InterfaceTest {
   	
   	public static void main(String[] args) {
   		
   		System.out.println(Flyable.MAX_SPEED);
   		
   		Plane plane = new Plane("hq", 002, 2);
   		plane.fly();
   		plane.stop();
   		
   	}
   }
   
   interface Flyable{
   	
   	int MAX_SPEED = 7900;	// 记住接口中的成员是固定的，这里的常量也是全局常量，只是省略了 public static final
   	public static final int MIN_SPEED = 1;
   	
   	public abstract void fly();	//与上面同理，这里的 public abstract 也可以省略
   	
   	public abstract void stop();
   	
   	 
   //	public Flyable() {	// no constructor in interface	
   //	}
   	
   }
   
   class Plane implements Flyable{
   	
   	
   	String name;
   	int number;
   	int age;
   	
   	public Plane(String name, int number, int age) {
   		this.name = name;
   		this.number = number;
   		this.age = age;
   	}
   
   	@Override
   	public void fly() {
   		System.out.println("start to fly");		
   	}
   
   	@Override
   	public void stop() {
   		System.out.println("come back");
   		
   	}
   	
   }
   
   abstract class Kite implements Flyable{
   
   	@Override
   	public void fly() {
   		
   	}
   	// 要么重写所有的抽象方法，要么把这个类定义为抽象类
   }
   ```

7. Java类可以实现多借口，从而弥补了Java单继承性的局限性

   书写格式：class AA extends BB implements CC, DD, EE

   先写继承再加接口

8. 类实现接口（多实现）

   类继承类（单继承）

   接口继承接口（多继承）

   ---

   

9. 接口的使用可以体现<u>多态性</u>

10. 接口实际上就是一种规范

    接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要...则 必须能...”的思想。继承是一个"是不是"的关系，而接口实现则是 "能不能" 的关系。

    接口的本质是契约，标准，规范，就像我们的法律一样。制定好后大家都 要遵守。

    ```java
    package com.hurjiang.interfacetest;
    
    public class USBTest{
    	
    	public static void main(String[] args) {
    		
    		Computer c = new Computer();
    		Flash f = new Flash();
    		
    		c.transferData(f);	//体现了接口使用的多态性
    		//其实要使用接口必须是利用多态性
    	}
    }
    
    class Computer{
    	
    	public void transferData(USB usb){
    		usb.start();
    		System.out.println("details");
    		usb.stop();
    	}
    }
    
    interface USB{
    		 
    	void start();
    	void stop();
    	
    }
    
    class Flash implements USB{
    
    	@Override
    	public void start() {
    		System.out.println("Flash start to work");	
    	}
    	@Override
    	public void stop() {
    		System.out.println("Flash stop working");	
    	}
    }
    
    class Printer implements USB{
    
    	@Override
    	public void start() {
    		System.out.println("Printer begin to work");	
    	}
    	@Override
    	public void stop() {
    		System.out.println("Printer stop working");
    	}
    }
    ```


### 匿名实现类和匿名对象

```java
// 1. 创建了接口的非匿名实现类的非匿名对象
		Flash f = new Flash();
		c.transferData(f);	//体现了接口使用的多态性
		//其实要使用接口必须是利用多态性
		
		// 2. 创建了接口的非匿名实现类的匿名对象
		c.transferData(new Printer());
		
		// 3. 创建了接口的匿名实现类的非匿名对象 (实现类是指接口的“类”吗)
		USB phone = new USB() {

			@Override
			public void start() {
				System.out.println("Phone start to work");				
			}
			@Override
			public void stop() {
				System.out.println("Phone stop working");
			}
		};
		c.transferData(phone);

		// 4. 创建类接口的匿名实现类的匿名对象
		c.transferData(new USB() {

			@Override
			public void start() {
				System.out.println("Phone start to work");
			}
			@Override
			public void stop() {
				System.out.println("Phone stop working");
			}	
		});
```

面试题：抽象类和接口有哪些异同？

### Proxy Design Modell

```java
package com.hurjiang.interfacetest;

public class ProxyStarTest {
	
	public static void main(String[] args) {
		
		Star s = new Proxy(new RealStar()); // 在字面上理解这么写的意思，但是不理解为什么在代码逻辑上可以这么写？
		
		s.confer();
		s.signContract();
		s.bookTicket();
		s.sing();
		s.collectMoney();
	}
}

interface Star{
	
	void confer();
	void signContract();
	void bookTicket();
	void sing();
	void collectMoney();
	
}

class RealStar implements Star{

	@Override
	public void confer() {
		//这里不写明星要面谈，所以是一种任务的分配，提前分配好，明星不需要做这个工作
	}
	@Override
	public void signContract() {
	}
	@Override
	public void bookTicket() {
	}
	@Override
	public void sing() {
		// 唱歌是不能代理的
		System.out.println("明星在唱歌");
	}
	@Override
	public void collectMoney() {
	}	
}

class Proxy implements Star{

	private Star realStar;	// 主要是还是不懂接口？
	
	public Proxy(Star realStar) {
		this.realStar = realStar;
	}
	
	@Override
	public void confer() {
		System.out.println("经纪人去面谈");
	}
	@Override
	public void signContract() {
		System.out.println("经纪人去签合同");
	}
	@Override
	public void bookTicket() {
		System.out.println("经纪人去订票");	
	}
	@Override
	public void sing() {
		//经纪人不能唱歌，所以还是让明星自己唱
		realStar.sing(); //这个功能我明白，但是为什么可以这么调呢？从Proxy里调RealStar的方法？
		// RealStar 和 Proxy 二者是什么关系？ 在代码层面上如何体现它们之间的代理关系？
	}
	@Override
	public void collectMoney() {
		System.out.println("经纪人去收钱");	
	}
}
```

### Factory Design Modell

### Quiz1 面试题 - 排错

```java
interface A { 
  int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
      System.out.println(x); 
    }
    public static void main(String[] args) {
        new C().pX();
		} 
}
```

A和B中都有x，并且接口和类是并列的两个结构，那到底在C中调的是哪个x呢？所以必须做以下的修改

`System.out.println(super.x);`	--> 调B的x

`System.out.println(A.x);` --> 调A的x，为什么可以这么调？因为接口中的常量是全局常量，这不过这里省略了 public static final

### Quiz2 面试题 - 排错

```java
interface Playable {
    void play();	//public abstract void play();
}
interface Bounceable {
    void play(); //public abstract void play();
}
interface Rollable extends Playable, Bounceable {
  Ball ball = new Ball("PingPang");
  // public static final Ball ball = new ...
  // ball can't be defined again
}
class Ball implements Rollable {
  private String name;
  public String getName() {
    return name;
  }
  public Ball(String name) { //constructor
    this.name = name;
  }
  public void play() { //override play()
    ball = new Ball("Football"); // no! ball can't be defined again, cause it's final
    System.out.println(ball.getName());
	} 
}
```



# Common Class

## Object Class

java.lang.Object

默认为所有类的父类

Object类中的功能（属性、方法）就具有通用性:

1. 属性：无
2. 方法：
3. 

### Quiz : == vs. equals

1. == 是运算符

   * 可以使用在基本数据类型变量和引用数据类型变量中

   - 如果比较的是基本数据类型变量：那就是比较两个变量保存的数据是否相等（不一定类型相同）

   - 如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体

     `char c = 65;` 

     `c == 65;?` true

     `c == 'A';?` true

   - == 的两边的变量类型必须一致，不然编译就会报错

2. equals

   * 是一个方法，不是运算符

   * 既然是方法，是类的一部分，基本数据类型变量是不能用方法的，所以只能适用于引用数据类型

   *  Object类中equals( )的定义：

      public boolean equals (Object obj) { return (this == obj); }

   * 说明：Object类中定义的equals( )和==的作用是相同的，就是比较两个对象的地址值是否相同，即两个引用是否指向同一个对象

   * 像String, Date, File, 包装类等都重写了Object类中equals( )方法。重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同

   * 通常情况下，我们自定义的类如果使用equals的话，也通常是想比较两个对象的实体内容是否相同。那么，我们就需要对Object类中equals( ) 进行重写

     重写要改的：比较两个对象的实体内容是否相同

     对equals( )进行重写:

     ```java
     public boolean equals(Object obj){
       if(this == obj){
         return true;
       }
       if(obj instanceof Customer){
         Customer cust = (Customer)obj;
         return this.age = cust.age && this.name.equals(cust.name);
       }else{
         return false;
       }
     }
     ```

     但是可以自动生成，所以一般不需要自己写

3. == 和 equals 容易混淆的原因

   equals在原初的设计中就只是比较内存的地址，但是因为在日常开发中，例如String这种引用类型也经常需要比较内容，而不是地址值，所以对于String而言，它的equals是被重写过的。这样，久而久之，在我们中间就形成了错误的观念，以为equals是可以比较内容的，但是其实只是因为重写的原因

### toString( ) 方法的使用

1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString( ) 方法

2.  Object类中toString( )的定义：

    ```java
    public String toString(){
      return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    ```

3. String, Date, File, 包装类等重写了Object类中的toString( )方法

   从而实现在调用对象的toString( )方法时，返回 “实体内容” 信息

4.  那么自定义类也可以重写toString( )方法，从而实现当调用此方法时，返回对象的“实体内容”

在进行String与其它类型数据的连接操作时，自动调用toString( )方法

```java
Date now = new Date();
System.out.println(“now=”+now); // 相当于
System.out.println(“now=”+now.toString());
```

#### Quiz-equals/toString

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220714135702869.png" alt="image-20220714135702869" style="zoom:30%;" />

<img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220714135806133.png" alt="image-20220714135806133" style="zoom:30%;" />

```java
package com.hurjiang.quiz9equalstostring;

public class Quiz9Test {
	
	public static void main(String[] args) {
		
		Circle c1 = new Circle(3.0);
		Circle c2 = new Circle(2.4, "red", 2.0);
		
		System.out.println("is color same: " + c1.getColor().equals(c2.getColor()));
		System.out.println("is radius same: " + c1.equals(c2));
		
		System.out.println(c1.toString());
		
	}
}
```

```java
package com.hurjiang.quiz9equalstostring;

public class GeometricObject {
	
	protected String color;
	protected double weight;
	
	protected GeometricObject() {
		super();	// 是不是也可以不用写？
		this.color = "weight";
		this.weight = 1.0;
	}
	protected GeometricObject(String color, double weight) {
		super();	// 是不是也可以不用写？
		this.color = color;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
```

```java
package com.hurjiang.quiz9equalstostring;

public class Circle extends GeometricObject{
	
	private double radius;
	
	
	public Circle() {
		super();
//		color = "white";
//		weight = 1.0;
		this.radius = 1.0;
	}
	public Circle(double radius) {
		super();
//		color = "white";
//		weight = 1.0;
		this.radius = radius;
	}
	public Circle(double radius, String color, double weight) {
		super(color, weight);
		this.radius = radius;
//		this.color = color;
//		this.weight = weight;
	}
	
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	public double findArea() {
		return Math.PI * this.radius * this.radius;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof Circle) {	//为什么是Circle不是GeometricObject? 因为题目之后的要求是比较两个圆的半径？
			Circle circle = (Circle)obj;
			return this.radius == circle.radius;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Circle [radius = " + radius + "]";
	}
	
}
```

## JUnit 单元测试

1. 在类中声明单元测试方式

   此时的单元测试方法：方法的权限是public，没有返回值，没有形参

2. 为了在方法体内测试相关的代码

3. @Test



# SpecialNote

## About the length, length(), size()

- `length`: attribute of array
- `length()`: method of String
- `size()`: method of Collection<E e>


## quiz
1. 判断闰年
可以被4整除，但是不能被100整除
可以被400整除

2. 如何获取三位数的百位，十位和个位？



# Java Guide Interview Questions

