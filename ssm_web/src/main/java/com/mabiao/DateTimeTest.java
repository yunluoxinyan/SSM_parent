package com.mabiao;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author created by mabiao on 2018/8/16
 */
public class DateTimeTest {
	public static void main(String[] args) {
		String s = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(s);
		String back_path = System.getProperty("user.home") + File.separator + "config_center" + File.separator;
		System.out.println(back_path);
		Long l = 0L;
		System.out.println(l.equals(0L));
//		LocalDateTime start = LocalDateTime.of(2018,7,14,0,0);
//		LocalDateTime end1 = LocalDateTime.of(2018,7,21,0,0);
//		LocalDateTime end2 = LocalDateTime.of(2018,10,13,0,0);
//		System.out.println("第二季度(无唐)：" + Duration.between(start, end1).toDays() + "天");
//		System.out.println("第二季度(有唐)：" + Duration.between(end1, end2).toDays() + "天");
//		double sum = 6550 * 3;
//		System.out.println("每天" + (sum / 91) + "元");
//		double money = sum / 91 * 84 / 4;
//		System.out.println("房租：" + money);
//
//		System.out.println("服务费每天：10.58");
//		System.out.println("服务费：" + (10.58 * 215 / 4));
//		try {
//			String date = "2018-08-24 11:44:06";
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date parse = df.parse(date);
//			System.out.println(parse);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Date d1 = new Date(1537459199000L);
////		Date now = new Date(System.currentTimeMillis());
////		Date end = new Date(System.currentTimeMillis() + (3600 * 24 * 1000));
////		if (d1.after(now) && d1.before(end)) {
//			System.out.println(d1);
////		}
		Calendar calendar = Calendar.getInstance();
		calendar.add(5, -1);
		System.out.println(calendar.getTime());
		Date d = new Date(1537240089000L);
		System.out.println(d);
		String strs = "123,456";
		List<String> list = Arrays.asList(strs.split(","));
		System.out.println(list);
		System.out.println(list.contains("123"));
	}

//	public static void main(String[] args) {
//		double d1 = 71.615548 + 3.529286;
//		double d2 = 53.711661 + 2.646964;
//		double sum = d1 * 98 + d2 * 84 + 2.646964 * 131;
//		System.out.println(14204 - sum);
//		System.out.println((14204 - sum) * 3);
//		double d3 = 6550 * 3 / 4 - 1758.92;
//		System.out.println(d3);
//	}
}
