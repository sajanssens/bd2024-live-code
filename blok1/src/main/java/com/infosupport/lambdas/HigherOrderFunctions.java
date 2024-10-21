package com.infosupport.lambdas;

import java.util.function.BiFunction;

public class HigherOrderFunctions {

    int op1 = 1;
    long op2 = 2;
    double result;

    // public void add() {
    //     System.out.println("Begin");
    //     result = op1 + op2;
    //     System.out.println("End");
    // }
    //
    // public void subtract() {
    //     System.out.println("Begin");
    //     result = op1 - op2;
    //     System.out.println("End");
    // }

    // More generic:

    public void execute(BiFunction<Integer, Long, Double> someFunction) {
        System.out.println("Begin");
        result = someFunction.apply(op1, op2);
        System.out.println("End");
    }

    public double getResult() {
        return result;
    }

    public static void main(String[] args) {
        HigherOrderFunctions hf = new HigherOrderFunctions();
        // hf.add();
        // System.out.println(hf.getResult());
        // hf.subtract();
        // System.out.println(hf.getResult());

        hf.execute((Integer a, Long b) -> (double) a + b);
        System.out.println(hf.getResult());
        hf.execute((Integer a, Long b) -> (double) a - b);
        System.out.println(hf.getResult());

    }
}
