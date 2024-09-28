package com.infosupport.h7;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Laptop {
    private String brand;
    private byte[] data;

    public Laptop(String brand) {
        this.brand = brand;
    }
}
