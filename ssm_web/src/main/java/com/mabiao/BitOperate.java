package com.mabiao;

/**
 * @program: SSM_parent
 * @description: 位运算
 * @author: mabiao
 * @create: 2019-03-18 10:54
 **/
public class BitOperate {

    public static void main(String[] args) {
        Integer i = 16;
//        int j1 = i >> 5;
//        int j2 = i << 5;
//        System.out.println(j1);
//        System.out.println(j2);
        System.out.println(i & (1 << 5));
    }
}
