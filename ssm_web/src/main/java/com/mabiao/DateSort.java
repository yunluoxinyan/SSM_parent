package com.mabiao;

import com.mabiao.domain.Info;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author created by mabiao on 2018/9/18
 */
public class DateSort {
	public static void main(String[] args) {
		/*List<Info> list = new ArrayList<>();
		Info i1 = new Info(new Date(1537277788622L));
		Info i2 = new Info(new Date(1537275788622L));
		list.add(i1);
		list.add(i2);
		list.sort((t1,t2) -> t2.getDate().compareTo(t1.getDate()));
		System.out.println(list);*/

//		Integer a = null;
//		if (a == 1) {
//			System.out.println(1);
//		}
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = df.parse(null);
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DATE,1);
//		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//		System.out.println(c.getTime());
//		c.add(Calendar.DATE,1);
//		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//		System.out.println(c.getTime());
//		try {
//			String search = "20181130-20181129";
//			String[] date = search.split("-");
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//			Date start = sdf.parse(date[0]);
//			Date end = sdf.parse(date[1]);
//			Calendar cStart = Calendar.getInstance();
//			cStart.setTime(start);
//			Calendar cEnd = Calendar.getInstance();
//			cEnd.setTime(end);
//			System.out.println(cStart.after(cEnd));
//			System.out.println(date.length == 2);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date now = null;
		Date beginTime = null;
		Date endTime = null;
		try {
			now = sdf.parse(sdf.format(new Date()));
			beginTime = sdf.parse("8:10");
			endTime = sdf.parse("9:40");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(now);
		System.out.println(beginTime);
		System.out.println(endTime);
	}
}
