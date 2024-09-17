package com.infosupport.h7;

public enum ClientManager {

    INSTANCE;

    // fields
    private String name;


    // methods

    public void doeMaarWat() {

    }
}

class Main{
    public static void main(String[] args) {
        ClientManager instance = ClientManager.INSTANCE;

        instance.doeMaarWat();
    }
}
