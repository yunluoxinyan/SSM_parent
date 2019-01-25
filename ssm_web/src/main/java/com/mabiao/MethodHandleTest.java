package com.mabiao;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author created by mabiao on 2018/7/30
 */
public class MethodHandleTest {
	class Grandfather{
		void say(){
			System.out.println("i am grandfather");
		}
	}

	class Father extends Grandfather {
		@Override
		void say() {
			System.out.println("i am father");
		}
	}

	class Son extends Father {
		@Override
		void say() {
			try {
				//1.7
//				MethodType mt = MethodType.methodType(void.class);
//				MethodHandle mh = lookup().findSpecial(Grandfather.class, "say", mt, getClass());
//				mh.invoke(this);

				//JDk1.8
				MethodType mt = MethodType.methodType(void.class);
				Field impl_lookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
				impl_lookup.setAccessible(true);
				MethodHandles.Lookup mlk = (MethodHandles.Lookup) impl_lookup.get(null);
				MethodHandle mh = mlk.findSpecial(Grandfather.class, "say", mt, Grandfather.class);
				mh.invoke(this);
			} catch (Throwable e) {
			}
		}
	}

	public static void main(String[] args) {
		(new MethodHandleTest().new Son()).say();
	}
}
