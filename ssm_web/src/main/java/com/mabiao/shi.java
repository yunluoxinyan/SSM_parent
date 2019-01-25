package com.mabiao;

/**
 * @author created by mabiao on 2018/9/12
 */
class A {
//	static boolean foo(char c) {
//		System.out.println(c);
//		return true;
//	}
//
//	public static void main(String[] args) {
//		int i = 0;
//		for(foo('A');foo('B')&&(i < 2);foo('C')){
//			i++;
//			foo('D');
//		}
//	}
	static {
		System.out.println(1);
	}
	public A(){
		System.out.println(2);
	}
}
class B extends A {
	static {
		System.out.println("a");
	}
	public B(){
		System.out.println("b");
	}
}

public class shi{
	public static void main(String[] args) {
//		A ab = new B();
//		ab = new B();
		String val = "1.0";
		Integer i = Integer.valueOf(val.substring(0,val.indexOf(".")));
		System.out.println(i);
	}
}