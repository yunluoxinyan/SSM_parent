package com.mabiao.classLoad;

/**
 * @author created by mabiao on 2018/7/26
 */
public class SuperClass {
	static {
		System.out.println("SuperClass init");
	}

	public static final int value = 4;
//	public static int value = 4;
}
