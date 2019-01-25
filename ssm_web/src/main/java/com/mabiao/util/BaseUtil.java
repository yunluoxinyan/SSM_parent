package com.mabiao.util;

import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BaseUtil
 *
 * @author jintaiyong
 */
public class BaseUtil {

	public static boolean isNullOrEmpty(List<?> list) {
		return list == null || list.size() < 1;
	}

	public static boolean hasElements(List<?> list) {
		return !isNullOrEmpty(list);
	}

	public static boolean isNullOrEmpty(Object[] arr) {
		return arr == null || arr.length < 1;
	}

	public static boolean hasElements(Object[] arr) {
		return !isNullOrEmpty(arr);
	}

	public static boolean isNullOrEmpty(Set<?> set) {
		return set == null || set.isEmpty();
	}

	public static boolean hasElements(Set<?> set) {
		return !isNullOrEmpty(set);
	}

	public static boolean isNullOrEmpty(Map<?, ?> model) {
		return model == null || model.isEmpty();
	}

	public static boolean hasElements(Map<?, ?> model) {
		return !isNullOrEmpty(model);
	}

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.length() < 1;
	}

	public static boolean hasContent(String str) {
		return !isNullOrEmpty(str);
	}

	public static boolean isNullOrTrimEmpty(String str) {
		return str == null || str.trim().length() < 1;
	}

	public static String currentDate(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

	public static final String PATTERN_default_datetime = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_default_date = "yyyy-MM-dd";

	public static String currentDateTime() {
		return new SimpleDateFormat(PATTERN_default_datetime).format(new Date());
	}

	public static String date2string(Date date, String format) {
		if (date == null) return null;
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * <pre>
	 * 返回类的名称（非全名称）
	 *
	 * e.g. com.jd.seomap.Test.class 返回 Test
	 * </pre>
	 *
	 * @param clazz
	 * @return
	 */
	public static String getSimpleClassName(Class<?> clazz) {
		if (clazz == null) return null;
		return clazz.getSimpleName();
	}

	/**
	 * <pre>
	 * 返回类的全名称
	 *
	 * e.g. com.jd.seomap.Test.class 返回 com.jd.seomap.Test
	 * </pre>
	 *
	 * @param clazz
	 * @return
	 */
	public static String getAllClassName(Class<?> clazz) {
		if (clazz == null) return null;
		return clazz.getName();
	}

	public static boolean isNumberic(String str) {
		if (isNullOrEmpty(str)) return false;

		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches())
			return false;
		return true;
	}

	public static <E> List<E> newList() {
		return new ArrayList<E>();
	}

	public static <E> List<E> newList(int initCapacity) {
		return new ArrayList<E>(initCapacity);
	}

	@SafeVarargs
	public static <E> List<E> newList(E... es) {
		if (es == null) return null;
		List<E> list = new ArrayList<E>(es.length);
		for (E e : es)
			list.add(e);
		return list;
	}

	public static <K, V> HashMap<K, V> newMap() {
		return new HashMap<K, V>();
	}

	public static <K, V> HashMap<K, V> newMap(int initCapacity) {
		return new HashMap<K, V>(initCapacity);
	}

	public static <E> Set<E> newSet() {
		return new HashSet<>();
	}

	public static <E> Set<E> newSet(E... es) {
		Set<E> set = new HashSet<>();
		for (E e : es)
			set.add(e);
		return set;
	}

	public static boolean notIn(int a, int... iArr) {
		return !in(a, iArr);
	}

	public static boolean in(int a, int... iArr) {
		for (int i : iArr) {
			if (a == i)
				return true;
		}
		return false;
	}

	public static String discardSensitive(String str) {
		if (isNullOrEmpty(str)) return "";

		int len = str.length();
		switch (len) {
			case 1:
				return "*";
			case 2:
				return "**";
			default:
				return str.charAt(0) + "****" + str.charAt(len - 1);
		}
	}

	public static String discardTelSensitive(String str) {
		if (isNullOrEmpty(str)) return "";

		int len = str.length();
		if (len < 11)
			return "*****";
		return str.substring(0, 3) + "****" + str.substring(7, len);
	}

	public static String safeMobile(String mobile) {
		if (isNullOrEmpty(mobile)) return "";

		int len = mobile.length();
		if (len < 11)
			return "*******";
		return mobile.substring(0, 3) + "****" + mobile.substring(7, len);
	}

//	public static String xssFilter(String message) {
//		return StringEscapeUtils.escapeHtml4(message);
//	}

	public static String bigDecimal2string(BigDecimal money, int scale) {
		if (money == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("0.");
			for (int i = 0; i < scale; i++)
				sb.append("0");
			return sb.toString();
		}
		return money.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

	public static Long default2long(String id, long defaultVal) {
		try {
			return Long.valueOf(id);
		} catch (Exception e) {
		}
		return defaultVal;
	}

	public static String base64Decode(String str) {
		return new String(Base64.getDecoder().decode(str));
	}

	public static String deleteHttpPrefix(String url) {
		if (!isNullOrTrimEmpty(url) && url.startsWith("http:"))
			return url.replaceFirst("http:", "");
		return url;
	}

	public static BigDecimal min(BigDecimal a, BigDecimal b) {
		return a.compareTo(b) < 0 ? a : b;
	}

	public static String join(String[] skuArr, String splitor) {
		if (isNullOrEmpty(skuArr)) return null;

		StringBuilder sb = new StringBuilder();
		for (String s : skuArr)
			sb.append(s).append(splitor);
		return sb.length() < 1 ? sb.toString() : sb.substring(0, sb.length() - 1).toString();
	}

	public static int string2int(String str, int defaultVal) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	public static BigDecimal string2bigDecimal(String str) {
		try {
			return new BigDecimal(str);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static boolean in(String s, String... in) {
		for (String i : in) {
			if (i == null)
				continue;
			if (i.equals(s))
				return true;
		}
		return false;
	}

	public static boolean notIn(String s, String... in) {
		return !in(s, in);
	}

	public static boolean isBetween(int num, int low, int high) {
		return num >= low && num <= high;
	}

	public static long string2long(String str, long defaultVal) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	public static boolean isLetterDigit(String str) {
		boolean result = false;
		try {
			String regex = "^[a-z0-9A-Z]+$";
			result = str.matches(regex);
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	public static <T> List<T> asList(Iterator<T> iterator) {
		ArrayList<T> l = new ArrayList<>();
		while (iterator.hasNext())
			l.add(iterator.next());
		return l;
	}

	public static <E> Set<E> asSet(List<E> list) {
		if (isNullOrEmpty(list)) return null;
		Set<E> set = Sets.newHashSetWithExpectedSize(list.size());
		list.forEach(e -> set.add(e));
		return set;
	}

	public static boolean equals(Object a, Object b) {
		if (a == b) return true;
		if (a == null || b == null) return false;
		return a.equals(b);
	}

}
