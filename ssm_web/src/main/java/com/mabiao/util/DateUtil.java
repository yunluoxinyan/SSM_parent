package com.mabiao.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by mabiao8 on 2018/12/24.
 */
public class DateUtil {
    public static void main(String[] args) {
//        Date d = new Date();
//        Date date = DateUtils.ceiling(d, Calendar.DATE);
//        Date date1 = DateUtils.addDays(date, 1);
//        System.out.println(date);
//        System.out.println(date1);

//        String i = "123,456，789，333";
//        String patternStr = "[,，，]";
//        Pattern pattern = Pattern.compile(patternStr);
//        String[] split = pattern.split(i);
//        for (String s : split) {
//            System.out.println(s);
//        }
        Date timeBegin = DateUtils.ceiling(new Date(), Calendar.DATE);
        System.out.println(timeBegin);
        Date timeEnd = DateUtils.addDays(timeBegin, 1);
        System.out.println(timeEnd);
    }
}
