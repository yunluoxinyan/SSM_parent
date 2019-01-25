package com.mabiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author created by mabiao on 2018/7/24
 */
public class ClassDemoTest {
//	static boolean foo(char c)
//	{
//		System.out.print(c);
//		return true;
//	}
//	public static void main( String[] argv )
//	{
//		int i = 0;
//		for ( foo('A'); foo('B') && (i < 2); foo('C'))
//		{
//			i++ ;
//			foo('D');
//		}
//	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		Integer[] i = list.toArray(new Integer[list.size()]);
		for (Integer integer : i) {
			System.out.println(integer);
		}
	}
}

