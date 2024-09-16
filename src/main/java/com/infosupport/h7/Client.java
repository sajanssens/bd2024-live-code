package com.infosupport.h7;

import static java.lang.Character.isUpperCase;

public class Client {
    // Static data:
    private static final String algemeneVoorwaarden = "Dit zijn de algemene..... ";

    // FIELDS (STATE)
    private int id = 0;
    private String name = null;

    // no arg constructor
    public Client() {
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String newName) {
        if (!isUpperCase(newName.charAt(0))) {
            System.err.println("Name must start with uppercase");
            return;
        }

        this.name = newName;
    }

    // Java bean convention:
    public void setId(int id) {
        this.id = id;
    }

    public static void printAlgemeneVoorwaarden() {
        System.out.println(algemeneVoorwaarden);
    }
}
