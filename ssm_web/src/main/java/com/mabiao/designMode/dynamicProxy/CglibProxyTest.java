package com.mabiao.designMode.dynamicProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author created by mabiao on 2018/8/3
 */
public class CglibProxyTest {

	public static void main(String[] args) {
		Actor a = new Actor();
		a.basicActor(3000);
		a.dangerActor(6000);

//		Actor proxyActor = (Actor) Enhancer.create(a.getClass(), new MethodInterceptor() {
//			@Override
//			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//				int money = (int) objects[0];
//				String name = method.getName();
//				if("basicActor".equals(name) && money > 1000) {
//					return method.invoke(a,money/2);
//				}
//				if("dangerActor".equals(name) && money > 4000) {
//					return method.invoke(a,money/2);
//				}
//				return method.invoke(a,money);
//			}
//		});

		Actor proxyActor = (Actor) Enhancer.create(Actor.class, new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				int money = (int) objects[0];
				String name = method.getName();
				if("basicActor".equals(name) && money > 1000) {
					return method.invoke(a,money/2);
				}
				if("dangerActor".equals(name) && money > 4000) {
					return method.invoke(a,money/2);
				}
				return method.invoke(a,money);
			}
		});

		proxyActor.basicActor(1000);
		proxyActor.basicActor(3000);
		proxyActor.dangerActor(2000);
		proxyActor.dangerActor(6000);
	}
}
