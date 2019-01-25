package com.mabiao;

import com.mabiao.domain.User;
import com.mabiao.util.HttpClientUtil;
import com.mabiao.util.URLEncodeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class SubStringTest {
//    public static void main(String[] args) {
//        String catInfo = "1-2-3";
//        String s = catInfo.substring(catInfo.lastIndexOf("-") + 1);
//        System.out.println(s);
//    }

    public static void main(String[] args) {
//        String s = URLEncodeUtil.encode("3497_8607||70697", "UTF8");
//        String dataFromUrl = HttpClientUtil.getDataFromUrl("http://fhs.jd.local/api/gettopicinfo?fhc=fhyd&sub=47290&ev=@" +
//                 s + "&stock=1&page=1&area_ids=1,72,4137,0", "UTF-8");
//        System.out.println(dataFromUrl);
//
//        System.out.println("1000027,23".contains("1000027"));
//        String s = "caixiao,,mabiao";
//        String[] str = s.split(",");
//        System.out.println(str.length);
//        System.out.println(str[1]);
     /*   List<User> list = new ArrayList<>();
        User user1 = new User("mabiao1",27);
        User user3 = new User("mabiao1",29);
        User user2 = new User("mabiao2",null);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        List<User> list1 = list.stream()
                .filter(p -> p.getAge() != null)
                .sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        List<User> collect = list.stream().filter(p -> p.getAge() == null).collect(Collectors.toList());
        list1.addAll(collect);
        System.out.println(list1);*/
//        String str = "123 345 45 6";
//        String[] s = str.split(" ");
//        System.out.println(s.length);
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
        StringBuilder sb = new StringBuilder();
        String ss1 = "123 456 678";
        String[] s1 = ss1.split(" ");
        String ss2 = "000";
        String[] s2 = ss2.split(",");
        List<String> list1 = Arrays.asList(s1);
        List<String> list2 = Arrays.asList(s2);
        Set<String> set = new HashSet<>(list1.size() + list2.size());
        set.addAll(list1);
        set.addAll(list2);
        for (String s : set) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString());
    }


}
