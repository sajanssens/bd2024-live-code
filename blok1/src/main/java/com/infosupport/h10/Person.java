package com.infosupport.h10;

import java.math.BigDecimal;

public abstract class Person {

    protected String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    abstract void ietsAbstracts(int i);

    void iets(int name) {
        ietsAbstracts(90);
        System.out.println(this.name + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person implements Taxable {

    private int stNr;

    Student(String name, int stNr) {
        super(name);
        this.stNr = stNr;
    }

    @Override
    void ietsAbstracts(int i) {
        String name = getName();
        super.iets(45);
        String s = this.name;
    }

    @Override
    public boolean hasSalary() {
        return false;
    }

    @Override
    public BigDecimal calculateIncomeTax(int level) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class Start {
    public static void main(String[] args) {
        Student student = new Student("Bram", 32);
        student.iets(2);
        student.ietsAbstracts(3);

        Taxable t = new Taxable() {

            @Override public boolean hasSalary() {
                return true;
            }

            @Override public BigDecimal calculateIncomeTax(int level) {
                return BigDecimal.TEN;
            }
        };

        // .. c = (Integer o) -> 0;
        System.out.println(t);
    }
}
