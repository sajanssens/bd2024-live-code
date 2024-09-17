package com.infosupport.h7;

import java.util.List;

import static java.lang.Character.isUpperCase;

public class Client {
    // Static data:
    private static final String algemeneVoorwaarden = "Dit zijn de algemene..... ";

    // FIELDS (STATE) ---------------------
    private int id = 0;
    private String name = null;
    private House myHouse;
    private List<Laptop> laptops;

    // CONSTRUCTORS -----------------------
    // no arg constructor
    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // METHODS (BEHAVIOUR) -----------------
    public void transferData(Laptop from, Laptop to) {
        int f = this.laptops.indexOf(from);
        int t = this.laptops.indexOf(to);
        if (f != -1 && t != -1) {
            byte[] data = from.getData();
            to.setData(data);
        } else {
            throw new IllegalArgumentException("Laptop from or to don't exist");
        }
    }

    public void setName(String newName) {
        // NPE: object.methodCall(), waarbij dan object = null
        if (newName == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        char firstLetter = newName.charAt(0);
        if (!isUpperCase(firstLetter)) {
            System.err.println("Name must start with uppercase");
            return;
        }

        String remainder = newName.substring(1);
        if (!remainder.toLowerCase().equals(remainder)) {
            System.err.println("Name must end with all lower case letters.");
            return;
        }

        this.name = newName;
    }

    // Java bean convention:
    public void setId(int id) {
        this.id = id;
    }

    public void setMyHouse(House h) {
        this.myHouse = h;
    }

    public String getName() {
        return name;
    }

    public void addLaptop(Laptop laptop) {
        this.laptops.add(laptop);
    }

    public static void printAlgemeneVoorwaarden() {
        System.out.println(algemeneVoorwaarden);
    }
}
