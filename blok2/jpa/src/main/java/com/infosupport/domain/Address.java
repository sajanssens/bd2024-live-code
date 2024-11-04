package com.infosupport.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private Integer housenumber;
    private String zip;
    private String city;
}
