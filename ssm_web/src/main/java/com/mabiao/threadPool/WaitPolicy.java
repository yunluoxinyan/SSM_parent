package com.mabiao.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author created by mabiao on 2018/10/27
 */
public class WaitPolicy implements RejectedExecutionHandler {
	private long waitIfBlock = 10;

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		if (executor.isShutdown()) {
			return;
		}
		int activeCount = executor.getActiveCount();
		long taskCount = executor.getTaskCount();
		long completedTaskCount = executor.getCompletedTaskCount();
		BlockingQueue<Runnable> queue = executor.getQueue();
		try {
			if (queue.remainingCapacity() <= 0) {
				Thread.sleep(waitIfBlock);
				//System.out.println("activeCount:" + activeCount + "taskCount:" + taskCount + "completedTaskCount:" + completedTaskCount);
			}
			executor.submit(r);
		} catch (InterruptedException e) {
			System.out.println(r);
		}
	}
}
