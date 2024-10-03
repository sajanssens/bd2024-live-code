package com.infosupport.unittesting;

public class MyMath {

    public static int fac(int n) {
        if(n >= 13 ){
            throw new ArithmeticException(String.format("fac(%d) is not supported (max is 12)", n));
        }
        if(n < 0){
            throw new IllegalArgumentException(String.format("fac(%d) is not supported (only positive numbers)", n));
        }
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}
