package com.mabiao.compareAndEqual;

import lombok.Data;

import java.util.*;

/**
 * @program: SSM_parent
 * @description: 人类
 * @author: mabiao
 * @create: 2019-03-25 16:31
 **/
@Data
public class Man implements Comparable<Man>{
    private Integer age;
    private String name;

    public Man(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Man() {
    }

    @Override
    public int compareTo(Man man) {
        if (!this.age.equals(man.age)) {
            return this.age > man.age ? 1 : -1;
        }
        if (!this.name.equals(man.name)) {
            return this.name.compareToIgnoreCase(man.name);
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Man> list = new ArrayList<>();
        Man m1 = new Man(10,"tom");
        Man m2 = new Man(10,"jerry");
        Man m3 = new Man(9,"zara");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.sort(Man::compareTo);
        list.sort(new ManComparator());
        System.out.println(list);
        Set<Man> set = new HashSet<>();
        set.add(m1);
        set.add(m2);
        System.out.println(set.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Man man = (Man) o;
        return Objects.equals(age, man.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
