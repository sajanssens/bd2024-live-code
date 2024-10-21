package com.infosupport.unittesting;

public class Program {

    public static void main (String[] args) {
        var m = new MyMath(new RandomProvider());
        System.out.println(m.throwDice());
        System.out.println(m.throwDice());
        System.out.println(m.throwDice());
        System.out.println(m.throwDice());
        System.out.println(m.throwDice());
        System.out.println(m.throwDice());
    }
}
