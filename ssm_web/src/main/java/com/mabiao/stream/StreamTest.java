package com.mabiao.stream;

import com.mabiao.domain.web.User;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author created by mabiao on 2018/11/13
 */
public class StreamTest {

	@Test
	public void test1() {
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			User user = new User(i);
			list.add(user);
		}
		List<User> collect = list.stream().sorted((x, y) -> y.getId() - x.getId()).collect(Collectors.toList());
		System.out.println(collect);
	}

	@Test
	public void test2() {
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("筛选列表: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("合并字符串: " + mergedString);
	}

	@Test
	public void test3() {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
	}

	@Test
	public void test4() {
		Stream<List<Integer>> inputStream = Stream.of(
				Collections.singletonList(1),
				Arrays.asList(2, 3),
				Arrays.asList(4, 5, 6)
		);
		Stream<Integer> outputStream = inputStream.
				flatMap(Collection::stream);
//		long sum = outputStream.mapToInt((x) -> x).summaryStatistics().getSum();
//		System.out.println(sum);
		outputStream.forEach(System.out::println);
	}
	
	@Test
	public void test5() {
		List<String> collect = Stream.of("one", "two", "three", "four")
				.filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e))
				.map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());
	}

	@Test
	public void test6() {
		List<Integer> list = new ArrayList<>();
		String text = "str";
		Optional.ofNullable(text).ifPresent(System.out::println);
	}

	@Test
	public void test7() {
		List<String> list = Arrays.asList("123", "456", "789");
		List<String> list1 = list.subList(0, 1);
		System.out.println(list1);
	}

	@Test
	public void test8() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE,1);
		String s = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		System.out.println(s);
	}

}
