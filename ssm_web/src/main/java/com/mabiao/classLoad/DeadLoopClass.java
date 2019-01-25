package com.mabiao.classLoad;

/**
 * @author created by mabiao on 2018/7/27
 */
public class DeadLoopClass {
	static {
		if(true) {
			System.out.printf(Thread.currentThread() + "init Class");
			while (true) {

			}
		}
	}


}

class Test{
	public static void main(String[] args) {
		Runnable script = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread() + "end");
			}
		};
		Thread t1 = new Thread(script);
		Thread t2 = new Thread(script);
		t1.start();
		t2.start();
	}
}