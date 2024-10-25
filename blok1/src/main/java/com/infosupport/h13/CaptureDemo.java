package com.infosupport.h13;

import java.util.ArrayList;
import java.util.List;

public class CaptureDemo {

    public static void main(String[] args) {
        var c = new CaptureDemo();

        List<Number> numbers = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<?> strings2 = new ArrayList<String>();

        c.doSomething(numbers);
        // c.doSomething(ints);
        // c.doSomething(strings);
        // c.doSomething(strings2); // CAPTURE OF

        c.doSomething2(numbers);
        c.doSomething2(ints);
        // c.doSomething2(strings);
        // c.doSomething2(strings2);
    }

    public void doSomething(List<Number> list) {

    }

    public void doSomething2(List<? extends Number> list) {

    }
}
