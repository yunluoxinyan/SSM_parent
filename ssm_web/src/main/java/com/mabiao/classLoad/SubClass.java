package com.mabiao.classLoad;

/**
 * @author created by mabiao on 2018/7/26
 */
public class SubClass extends SuperClass {
	static {
		System.out.println("SubClass init");
	}
}
