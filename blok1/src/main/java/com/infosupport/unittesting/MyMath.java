package com.infosupport.unittesting;

import java.math.BigInteger;
import java.util.Random;

public class MyMath {
    private final RandomProvider randomProvider;

    public MyMath(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

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

    public static BigInteger fac(BigInteger n) {
        if(n.compareTo(BigInteger.ZERO) < 0){
            throw new IllegalArgumentException(String.format("fac(%d) is not supported (only positive numbers)", n));
        }
        if(n.compareTo(BigInteger.ONE) > 0){
            return n.multiply(fac(n.subtract(BigInteger.ONE)));
        }

        return BigInteger.ONE;
    }

    public static double areaOfCircle(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    public int throwDice() {
        var rand = (randomProvider.random() * 6) + 1;
        return (int) Math.floor(rand);
    }

    public static int throwDice2(Random r) {
        var d = r.nextDouble();
        var rand = (d * 6) + 1;
        return (int) Math.floor(rand);
    }
}
