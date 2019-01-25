package com.mabiao.classLoad;

import sun.management.VMManagement;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;

/**
 * @author created by mabiao on 2018/7/31
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException{
		// mxBean，记录了class加载的数量
		ClassLoadingMXBean mxBean = ManagementFactory.getClassLoadingMXBean();

		// ClassLoadingImpl是mxBean的真正实现类
		Class<?> clazz = Class.forName("sun.management.ClassLoadingImpl");
		Field[] fields = clazz.getDeclaredFields();
		Field vmManagementField = fields[0];
		vmManagementField.setAccessible(true);

		// 得到了ClassLoadingImpl里面的字段"jvm"，有了它我们可以得到class load花费的时间
		VMManagement vm = (VMManagement) fields[0].get(mxBean);

		System.out.println("loaded class 数量:" + mxBean.getLoadedClassCount() + " time: " + vm.getClassLoadingTime());

		TestLoadClass test = new TestLoadClass();

		System.out.println("loaded class 数量:" + mxBean.getLoadedClassCount() + " time: " + vm.getClassLoadingTime());

		test.loadSomeClass();    // 第一次load耗时会长

		System.out.println("loaded class 数量:" + mxBean.getLoadedClassCount() + " time: " + vm.getClassLoadingTime());

		test.loadSomeClass();    // class已经load过，执行很快

		System.out.println("loaded class 数量:" + mxBean.getLoadedClassCount() + " time: " + vm.getClassLoadingTime());

		test.loadSomeClass();    // class已经load过，执行很快

		System.out.println("loaded class 数量:" + mxBean.getLoadedClassCount() + " time: " + vm.getClassLoadingTime());
	}
}
