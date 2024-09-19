package com.infosupport.h7.mvc.model.domain;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

