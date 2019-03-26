package com.mabiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSM_parent
 * @description: 错误检测机制
 * @author: mabiao
 * @create: 2019-03-26 11:21
 **/
public class ListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List subList = masterList.subList(0, 3);

//        masterList.add("ten");
//        masterList.remove(0);

        for (Object o : subList) {
            System.out.println(o);
        }

        subList.clear();
        subList.add("six");
        subList.add("seven");
        subList.remove(0);

        System.out.println(masterList);
    }
}
