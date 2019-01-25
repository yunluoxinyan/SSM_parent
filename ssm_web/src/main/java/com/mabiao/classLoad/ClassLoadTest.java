package com.mabiao.classLoad;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author created by mabiao on 2018/7/27
 */
public class ClassLoadTest {
	public static void main(String[] args) throws Exception{
		ClassLoader myLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String filename = name.substring(name.lastIndexOf(".")+ 1 ) + ".class";
					InputStream is = getClass().getResourceAsStream(filename);
					if(is == null) {
						return super.loadClass(name);
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("com.mabiao.classLoad.ClassLoadTest").newInstance();
		System.out.println(obj.getClass());
		//不同类加载器加载的类，来自同一个class文件，但依然是两个独立的类
		System.out.println(obj instanceof com.mabiao.classLoad.ClassLoadTest);
	}
}
