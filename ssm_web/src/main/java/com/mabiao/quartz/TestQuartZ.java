package com.mabiao.quartz;

import java.util.Date;

/**
 * @author created by mabiao on 2018/10/31
 */
public class TestQuartZ {

	public void run(){
		try {
			Date d = new Date(System.currentTimeMillis());
			System.out.println(d);
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
