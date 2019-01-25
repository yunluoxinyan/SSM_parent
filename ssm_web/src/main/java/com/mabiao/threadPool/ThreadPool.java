package com.mabiao.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author created by mabiao on 2018/10/24
 */
public class ThreadPool {

//	private static ExecutorService executorService = new ThreadPoolExecutor(10,20,60L,
//			TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(50),new ThreadPoolExecutor.CallerRunsPolicy());
	private static ExecutorService executorService = new ThreadPoolExecutor(10,20,60L,
			TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(10),new WaitPolicy());

	public static void main(String[] args) {

		for (int n = 0; n <= 2;n++) {

			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < 10000; i++) {
				list.add(i);
			}

			System.out.println(n+"~~~~~~~~");
			for (int x = 0; x < list.size(); x++) {
				final int j = list.get(x);
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						say(j);
					}
				});
			}

		}



	}

	private static void say(int j) {
		if(Thread.currentThread().getName().contains("ain")) {
			System.out.println(Thread.currentThread().getName() + ":" + j);
		}
	}
}
