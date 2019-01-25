package com.mabiao.designMode;


import com.mabiao.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author created by mabiao on 2018/8/3
 */
public class ReflectTest {

	public static User getInstance() {
		User user = null;
		try {
			user = (User) Class.forName("com.mabiao.domain.User").getConstructor(String.class, int.class).newInstance("Tom", 11);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void main(String[] args) {
//		User user = getInstance();
//		System.out.println(user.getAge());
//		System.out.println(user.getName());
		reflectMethod();
	}

	public static Object reflectMethod(){
		Object object = null;
		User user = new User();
		try {
			Method method = User.class.getMethod("sayHello");
			object = method.invoke(user);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
}
