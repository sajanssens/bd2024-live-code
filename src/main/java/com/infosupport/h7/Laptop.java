package com.infosupport.h7;

public class Laptop {
    private String brand;
    private byte[] data;

    public Laptop(String brand) {
        this.brand = brand;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
