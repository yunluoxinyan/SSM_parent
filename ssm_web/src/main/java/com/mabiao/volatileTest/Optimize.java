package com.mabiao.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by mabiao on 2018/8/2
 */
public class Optimize {

	public static AtomicInteger race = new AtomicInteger();

	public static void increase() {
		race.incrementAndGet();
	}

	public static final int THREAD_COUNT = 20;

	public static void main(String[] args) throws Exception{
		Thread[] threads = new Thread[THREAD_COUNT];

		for(int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 10000; i++) {
						increase();
					}
					System.out.println(Thread.currentThread().getName() + ":end!");
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 2) {
			//让出cpu给其他线程
			Thread.yield();
		}

		System.out.println(race);
	}

	/**
	 * AtomicInteger的incrementAndGet方法为原子性
	 * idea会返回有2个线程  是因为多了个monitor ctrlbreak线程。
	 */
}
