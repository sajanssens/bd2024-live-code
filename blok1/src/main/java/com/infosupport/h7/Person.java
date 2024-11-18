package com.infosupport.h7;

public class Person {

    private String firstName;

    Person(String firstName, int age) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
}

class Start {   //          {"", ""}
    public static void main(String[] args) {
        Person p = new Person("John Smith", 25);
        System.out.println(p.getFirstName());
    }
}
