package com.infosupport.h4;

public class RecursionDemo {

    public void reeks(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }
    }

    public void reeksRecursive(int n) {
        if (n <= 0) return;

        System.out.println(n);
        reeksRecursive(n - 1);
    }

    public void printAlleTafelsTotEnMet(int n) {
        if (n <= 0) { return; }
        printAlleTafelsTotEnMet(n - 1);
        printTafelVan(n);
    }

    public void printTafelVan(int x) {
        printTafelVan(x, 1);
    }

    private void printTafelVan(int x, int slag) {
        if (slag > 10) { return; }
        System.out.printf("%-4d x %-4d = %-4d%n", slag, x, slag * x);
        printTafelVan(x, slag + 1);
    }

    public static void main(String[] args) {
        RecursionDemo recursionDemo = new RecursionDemo();

        recursionDemo.reeks(10);
        recursionDemo.reeksRecursive(10);
        recursionDemo.printTafelVan(3);
        recursionDemo.printAlleTafelsTotEnMet(20);

    }
}
