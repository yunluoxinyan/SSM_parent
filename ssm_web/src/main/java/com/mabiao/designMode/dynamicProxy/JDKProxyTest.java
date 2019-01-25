package com.mabiao.designMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author created by mabiao on 2018/8/3
 */
public class JDKProxyTest {

	public static void main(String[] args) {
		Actor a1 = new Actor();
		a1.basicActor(2000);
		a1.dangerActor(5000);

		IActor proxyActor = (IActor) Proxy.newProxyInstance(a1.getClass().getClassLoader(), a1.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				int money = (int) args[0];
				String name = method.getName();
				if("basicActor".equals(name) && money > 2000) {
					return method.invoke(a1,money/2);
				}
				if("dangerActor".equals(name) && money > 5000) {
					return method.invoke(a1,money/2);
				}
				return method.invoke(a1,money);
			}
		});

		proxyActor.basicActor(1000);
		proxyActor.basicActor(3000);
		proxyActor.dangerActor(2000);
		proxyActor.dangerActor(6000);
	}
}
