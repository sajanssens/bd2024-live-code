package com.infosupport.h1;

public class FactorialDemo {

    public static int factorial(int n) {
        int result = n;
        for (int i = n - 1; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    public static int factorialFunctionalStyle(int n) {
        System.out.println("factorialFunctionalStyle for n = " + n);
        if (n <= 1) return 1; // stop condition

        return n * factorialFunctionalStyle(n - 1);
    }
}
