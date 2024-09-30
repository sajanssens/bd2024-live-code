package com.infosupport.lambdas;

import java.util.function.Function;

public class LambdasDemo {

    // class scope
    // class scope
    // class scope
    // class scope

    class Functies {
        public Integer f(Integer x) {
            int y = x * x;
            return y;
        }
    }

    public static void main(String[] args) {
        // local  scope

        // Functie als method in een class declareren ----------------
        // Functies functies = new Functies();
        // .. en aanroepen
        // int result = functies.f(2);

        // nu als lambda declareren ----------------------------------
        Function<Integer, Integer> kwadrateer =
                (Integer x) -> {
                    int y = x * x;
                    return y;
                };
        // ... en aanroepen
        int y = kwadrateer.apply(2);

        // en nog een,m aar nu compacter:
        Function<Integer, Integer> geefEenHoger = x -> x + 1;

        // Nu kan ik deze functies doorgeven aan andere functies:
        Calculator calculator = new Calculator();

        calculator.voerUitMet(kwadrateer);
        System.out.println(calculator.getResult());

        calculator.voerUitMet(geefEenHoger);
        System.out.println(calculator.getResult());

        // kan ook inline (als anonieme lambda):
        calculator.voerUitMet(x -> x - 1);
        System.out.println(calculator.getResult());
    }

    private static class Calculator {

        int x = 2;
        int y = 0;

        public void voerUitMet(Function<Integer, Integer> f) {
            this.y = f.apply(x);
        }

        public int getResult() {
            return y;
        }
    }
    // class scope
    // class scope
    // class scope
    // class scope
}


