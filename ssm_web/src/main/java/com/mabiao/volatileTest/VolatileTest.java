package com.mabiao.volatileTest;

import org.apache.velocity.runtime.directive.Foreach;

/**
 * @author created by mabiao on 2018/8/1
 */
public class VolatileTest {
	public static volatile int race = 0;

	public static void increase() {
		race++;
	}

	public static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 2) {
			Thread.yield();
		}

		System.out.println(race);
	}

	/**
	 * 只能保证race的值在放入栈顶时是正确的
	 * 可能在进行++操作时，其他线程已经修改了race的值，在执行完后在同步会主内存，就存在错误了
	 * 改进 见Optimize
	 */
}
