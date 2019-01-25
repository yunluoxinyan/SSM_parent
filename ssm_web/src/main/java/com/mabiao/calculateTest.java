package com.mabiao;

import java.math.BigDecimal;

/**
 * Created by mabiao8 on 2018/12/4.
 */
public class calculateTest {
    public static void main(String[] args) {

        BigDecimal b = new BigDecimal((double) 123456789L/(10000L * 100));

        Double result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(result);

    }

}
