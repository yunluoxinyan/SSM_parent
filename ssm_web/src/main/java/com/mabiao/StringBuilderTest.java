package com.mabiao;

/**
 * @author created by mabiao on 2018/9/4
 */
public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("满减；");
		String substring = sb.substring(0, sb.length() - 1);
		System.out.println(substring);
	}
}
