package com.infosupport.h3;

import java.math.BigDecimal;

public class DoubleDemo {
    public static void main(String[] args) {
        double result = 0.53f + 0.01f;
        System.out.println(result);
        // 1111.1001
        BigDecimal mars = new BigDecimal("0.53");
        BigDecimal opslag = new BigDecimal("0.01");
        BigDecimal add = mars.add(opslag);
        System.out.println(add);
    }
}
