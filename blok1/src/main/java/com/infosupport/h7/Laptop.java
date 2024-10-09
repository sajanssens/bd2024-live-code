package com.infosupport.h7;

import lombok.*;

@Builder
public class Laptop {
    private String brand;

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    private byte[] data;

    public Laptop(String brand) {
        this.brand = brand;
    }

    public Laptop(String brand, byte[] data) {
        this.brand = brand;
        this.data = data;
    }
}
