package com.mabiao;

import java.math.BigDecimal;

/**
 * Created by mabiao8 on 2018/12/12.
 */
public class MoneyTest {
    public static void main(String[] args) {
        long value = 12389068L;
        BigDecimal b = new BigDecimal("" + value/1000000);
        Double amount = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(amount);

        long value1 = 12384851L;
        BigDecimal b1 = new BigDecimal("" + value1/1000000);
        Double amount1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        amount1 = amount1 + amount;
        System.out.println(amount1);

        value += value1;
        System.out.println(value);

        BigDecimal amountBig = new BigDecimal((double) value/1000000);
        Double amount2 = amountBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(amount2);
    }
}
