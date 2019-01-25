package com.mabiao;

import org.junit.Test;

/**
 * @program: SSM_parent
 * @description: 测试类
 * @author: mabiao
 * @create: 2019-01-15 10:48
 **/
public class TestController extends BaseController {

    @Test
    public void test() {
        super.list.remove("mabiao8");
        super.print();
    }

    @Test
    public void test1() {
        int i = 1;
        long j = 2L;
        System.out.println(i + j);
    }
}
