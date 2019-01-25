package com.mabiao;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @author created by mabiao on 2018/8/15
 */
public class TestMethodReplacer implements MethodReplacer{
	@Override
	public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
		System.out.println("ExchangeMe");
		return null;
	}
}
