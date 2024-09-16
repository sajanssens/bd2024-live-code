package com.infosupport.h7;

public class StartHRMSystem {
    public static void main(String[] args) {
        Client.printAlgemeneVoorwaarden();

        Client b = new Client();
        b.setName("bram");
        b.setId(3);

        Client s = new Client(4, "Zaran");
        s.setName("Saran");
    }
}
