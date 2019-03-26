package com.mabiao;

import org.junit.Test;

import java.util.Date;

/**
 * @program: SSM_parent
 * @description: volatile关键字
 * @author: mabiao
 * @create: 2019-03-20 10:45
 **/
public class VolatileTest {

    /**
     * 在server启动模式下，如果不加volatile关键字，在编译时会将不改变的变量提到循环体外，导致死循环
     */
    volatile static boolean sleep;

    public static void main(String[] args) {
       while (sleep) {
           System.out.println(1);
       }
    }

    @Test
    public void test(){
        System.out.println(new Date().toString());
    }

}
