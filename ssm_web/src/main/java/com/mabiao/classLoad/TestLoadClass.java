package com.mabiao.classLoad;

import com.google.common.collect.Lists;

/**
 * @author created by mabiao on 2018/7/31
 */
public class TestLoadClass {
	public void loadSomeClass() {
		long start = System.currentTimeMillis();

		Class[] c1 = {
				String.class,   // java lang的
				Integer.class,  // java lang的
				Lists.class
		};

		System.out.println(System.currentTimeMillis() - start);
	}
}
