package com.infosupport.h7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StartHRMSystem {
    public static void main(String[] args) {
        int nextHouseId = 0;

        Client.printAlgemeneVoorwaarden();

        Client b = new Client();
        b.setName("bram");
        b.setId(3);

        Client s = new Client(4, "Zaran");
        s.setName("Saran");

        nextHouseId++;
        House h = new House(nextHouseId);
        b.setMyHouse(h);

        b.addLaptop(new Laptop("DELL"));
        b.addLaptop(new Laptop("HP"));
    }
}
