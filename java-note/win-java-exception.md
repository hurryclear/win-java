# 9 Exception

语法错误和逻辑错误不是异常

## 分类

1. Error: Java虚拟机无法解决的严重问题。如:JVM系统内部错误、资源 耗尽等严重情况。比如:StackOverflowError和OOM。

   **一般不编写针对性的代码进行处理。**

   1. 栈溢出：java.lang.StackOverflowError
   2. 堆溢出：java.lang.OutOfMemoryError

2. Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如: 

   - 空指针访问

   - 试图读取不存在的文件

   - 网络连接中断 

   - 数组角标越界

   <img src="/Users/hurjiang/Library/Application Support/typora-user-images/image-20220721103145398.png" alt="image-20220721103145398" style="zoom:50%;" />

​		red: 编译异常

​		blue: 运行异常

## 常见运行时异常

1. NullPointerException

```java
public void test1() {
		int [] arr = null;
		System.out.println(arr[3]);	
	}
```

2. IndexOutOfBoundsException

3. ClassCastException (运行异常)

   ```java
   public void  test3(){
     Object obj = new Date();
     String str = (String)obj;
   }
   ```

   但是不明白为什么会异常

4. NumberFormatException

   ```java
   public void test4(){
     String str = "123";
     str = "abc";
     int num = Integer.parseInt(str);
   }
   ```

5. InputMismatchException

   ```java
   public void test5(){
     Scanner scanner = new Scanner(System.in);
     int score = scanner.nextInt();
     System.out.println(score);
   }
   ```

6. ArithmeticException

   ```java
   public void test6(){
     int a = 10;
     int b = 0;
     System.out.println(a/b);
   }
   ```

## 常见编译时异常

略

## 异常的处理 - 抓抛模型

过程一 “抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出。一旦抛出对象后，之后的代码就不再执行了

过程二 “抓”：可以理解为异常的处理方式 1. try-catch-finally 2. throws

### 异常处理机制一：try-catch-finally

模版

```java
try{
  //可能出现异常的代码
}catch(异常类型1 变量名1){
  //处理异常的方式1
}catch(异常类型2 变量名2){
  //处理异常的方式2
}catch(异常类型3 变量名3){
  //处理异常的方式3
}....
finally{
  //一定会执行的代码
}
```

1. finally是可选的

2. 使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会成一个对应异常类的对象，根据此对象的类型，到catch中进行匹配

3. 一旦try中的异常对象匹配到某一个catch时，就进入此catch中进行异常处理。一旦处理完成，就跳出当前的try-catch结构（在没有finally的情况下），然后继续执行后面的代码

4. catch中的异常类型，如果没有子父类关系，则哪个在上，哪个在下没有关系。但是如果有子父类关系，则要求子类一定声明在父类的上面，否则会报错

5. 常用的异常对象处理方式：

   String getMessage()

   printStackTrace()

6. 在try结构中声明的变量，在出了try结构之后，就不能被调用了

7. try-catch-finally 结构可以嵌套

体会1：使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍可能报错。相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现

体会2：开发中，由于运行时异常比较常见，所以我们通常不针对运行时异常编写try-catch-finally。但是针对编译时异常，我们一定要考虑异常的处理

#### 关于finally

1. finally是可选的
2. finally中声明的是一定会被执行的代码，即使catch中又出现异常了，try中有return语句，catch中有return语句等情况
3. 像数据库连接、输入输出流、网络编程中的Socket等资源，JVM不能自动回收，这就要求我们自己手动地进行资源释放。此时的资源释放就需要声明在finally中

### 异常处理机制二：throws + 异常类型

1. "throws" + 异常类型 写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会被抛出。异常代码后续的代码，就不再执行！

2. 两种机制的比较

   try-catch-finally 的处理机制真正地将异常处理掉了

   throws的的机制只是将异常抛给了方法的调用者，并没有真正解决异常，要想最后解决异常，必须再用try-catch-finally

```java
package com.hurjiang.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest3 {
	
	public static void main(String[] args) {
		try{
			method2();
		}catch(IOException e) {
			e.printStackTrace();  
		}
		
		method3();
	}
	
	public static void method3() {
		try {
			method2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method2() throws FileNotFoundException,IOException{
		method1();
	}
	
	
	public static void method1() throws FileNotFoundException, IOException{
		File file = new File("hello.txt");
		FileInputStream fis = new FileInputStream(file);
		
		int data = fis.read();
		while(data != -1) {
			System.out.println((char)data);
			data = fis.read();
		}
		fis.close();
		System.out.println("test");
	}
}
```

### 开发中对两种处理机制的选择

1. 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能用throws，那么子类就只能用try-catch-finally方式
2. 执行的方法a中，先后又调用了另外的几个方法，这个几个方法是递进关系执行的。建议用throws的方式处理这几个方法。而执行的方法a可以考虑使用try-catch-finally的方式处理

## 手动抛出异常：throw

```java
package com.hurjiang.exception;

public class ExceptionTest4 {
	
	public static void main(String[] args){
		try {
			Student s = new Student();
			s.regist(-1);
			System.out.println(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

class Student{
	
	private int id;
	
	public void regist(int id) throws Exception{	// throws 异常的处理
		if(id > 0) {
			this.id = id;
		}else {
//			System.out.println("输入的数据非法！");
//			throw new RuntimeException("输入的数据非法！");
			throw new Exception("输入的数据非法！"); //生成一个异常对象
		}
	}
}
```

## 用户自定义异常类

跳过了，看不懂
