package com.mabiao.classLoad;

/**
 * @author created by mabiao on 2018/7/27
 */
public class StaticResolution {
	public static void sayHello(){
		System.out.println("hello");
	}

	public static void main(String[] args) {
		StaticResolution.sayHello();
	}

	//javap -verbose StaticResolution
	//可以查看是通过invokestatic命令调用的
	/**
	 * 静态方法  私有方法  父类方法   实例构造器  4个为非虚方法  在类加载的解析阶段
	 * 就从符号应用-->直接引用
	 */
}
