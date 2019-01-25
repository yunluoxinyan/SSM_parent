package com.mabiao.genericityWithOverLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by mabiao on 2018/7/31
 */
public class genericTypes {

	//需要jdk1.6
//	public static String method(List<String> list){
//		System.out.println("invoke List<String>");
//		return "";
//	}

	public static int method(List<Integer> list) {
		System.out.println("invoke List<Integer>");
		return 1;
	}

	public static void main(String[] args) {
//		method(new ArrayList<String>());
//		method(new ArrayList<Integer>());
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));

		/**
		 *  "=="运算在不遇到算术运算的情况下不会自动拆箱
		 *  equals()方法不处理数据转型
		 */
	}
}
