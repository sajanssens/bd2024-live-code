package com.infosupport.h7.mvc.model.domain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isUpperCase;

public class Client {
    // Static data:
    private static final String algemeneVoorwaarden = "Dit zijn de algemene..... ";
    private static int nextId = 0;

    // FIELDS (STATE) ---------------------
    private long id = 0;
    private String name = null;
    private House myHouse;
    private List<Laptop> laptops = new ArrayList<>();

    // CONSTRUCTORS -----------------------
    // no arg constructor
    public Client() {
    }

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(long id, String name, House myHouse, List<Laptop> laptops) {
        this.id = id;
        this.name = name;
        this.myHouse = myHouse;
        this.laptops = laptops;
    }

    // METHODS (BEHAVIOUR) -----------------
    public boolean transferData(Laptop from, Laptop to) {
        int f = this.laptops.indexOf(from);
        int t = this.laptops.indexOf(to);
        if (f != -1 && t != -1) {
            byte[] data = from.getData();
            to.setData(data.clone());
            return true;
        } else {
            throw new IllegalArgumentException("Laptop from or to don't exist");
        }
    }

    // Java bean convention:

    public void setName(String newName) {
        // NPE: object.methodCall(), waarbij dan object = null
        if (newName == null || newName.isBlank()) {
            System.err.println("Name may not be null");
            throw new IllegalArgumentException("Name may not be null");
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

    public void setId(long id) {
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

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public static void printAlgemeneVoorwaarden() {
        System.out.println(algemeneVoorwaarden);
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myHouse=" + myHouse +
                ", laptops=" + laptops +
                '}';
    }
}
