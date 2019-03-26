package com.mabiao.compareAndEqual;

import java.util.Comparator;

/**
 * @program: SSM_parent
 * @description: 比较器
 * @author: mabiao
 * @create: 2019-03-26 09:54
 **/
public class ManComparator implements Comparator<Man> {

    @Override
    public int compare(Man o1, Man o2) {
        if (!o1.getAge().equals(o2.getAge())) {
            return o1.getAge() > o2.getAge() ? 1 : -1;
        }
        if (!o1.getName().equals(o2.getName())) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
        return 0;
    }
}
