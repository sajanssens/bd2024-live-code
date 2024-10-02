package com.infosupport.h13.use;

import java.util.ArrayList;

public class GenericsUse {
    public static void main(String[] args) {
        // Generic Types
        ArrayList rawTypedList = new ArrayList();
        rawTypedList.add("OK");
        // rawTypedList.add(90);
        for (Object o : rawTypedList) {
            if (o instanceof String) {
                int length = ((String) o).length();
                System.out.println(length);
            }
        }

        // type           ident.  = new type()
        ArrayList<String> list    = new ArrayList<>(); // type inference, diamond syntax since java 7
        list.add("OK");
        // list.add(90);

        for (String s : list) {
            System.out.println(s.length());
        }
    }
}
