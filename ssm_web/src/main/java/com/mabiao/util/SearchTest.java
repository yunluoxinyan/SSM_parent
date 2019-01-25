package com.mabiao.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author created by mabiao on 2018/8/2
 */
public class SearchTest {

//	public static void main(String[] args) {
//		String gbk = URLEncodeUtil.encode("sheme", "GBK");
//		System.out.println(gbk);
//		int i = 1;
//		int j = 1;
//		System.out.println(i | j);

//		Integer pageCount;
//		Integer pageSize = 5;
//		Integer size = 12;
//		pageCount = size % pageSize == 0 ? size / pageSize : (size / pageSize + 1);
//		System.out.println(pageCount);
//
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list = list.subList(3, 5);
//		System.out.println(list);
//	}
//
//	private static String str1 = null;

	public static void main(String[] args) {
		String gbk = URLEncodeUtil.encode("机车夹克","gbk");
//		String gbk = URLEncodeUtil.encode("连衣裙", "GBK");
		System.out.println(gbk);
//		StringBuilder temp = new StringBuilder();
//		temp.append("L").append("123||").append("M").append("123").append("||");
//		String s = temp.substring(0, temp.lastIndexOf("||"));
//		System.out.println(s);
//		str1 = "123";
//		change(str1);
//		System.out.println(gbk);
	}

	/*public static void main(String[] args) {
		Integer opTotal;
		String url = "http://10.187.52.155/promo/nologinmgets?source=toplife&origin=1&skuids=4311729";
		String res = HttpClientUtil.getDataFromUrl(url, "GBK");
		String resultInfo = res.substring(1,res.length()-1);
		if ("ERROR".equals(res)) {
			//失败后显示特惠按钮以便下次查找
			opTotal = 1;
		} else {
			Map resMap = JsonUtil.toObject(resultInfo, Map.class);
			if (resMap == null) {
				opTotal = 1;
				System.out.println(opTotal);
			} else {
				System.out.println("true");
			}
		}
	}*/

	public static void change(String str) {
		str = "welcome";
	}
}
