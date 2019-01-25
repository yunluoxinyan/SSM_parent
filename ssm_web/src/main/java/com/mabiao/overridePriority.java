package com.mabiao;

import java.io.Serializable;

/**
 * @author created by mabiao on 2018/7/30
 */
public class overridePriority {

	public static void sayHello(Object arg){
		System.out.println("hello object");
	}

	public static void sayHello(int arg){
		System.out.println("hello int");
	}

	public static void sayHello(long arg){
		System.out.println("hello long");
	}

	public static void sayHello(Character arg){
		System.out.println("hello Character");
	}

	public static void sayHello(char arg){
		System.out.println("hello char");
	}

	public static void sayHello(char... arg){
		System.out.println("hello char ...");
	}

	public static void sayHello(Serializable arg){
		System.out.println("hello Serializable");
	}

	public static void main(String[] args) {
		sayHello('a');
	}

	/**
	 * 一次注释执行顺序  char  int  long  float  double  character  Serializable  object  char...
	 */
}
