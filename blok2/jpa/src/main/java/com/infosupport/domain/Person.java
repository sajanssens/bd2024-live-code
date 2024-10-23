package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
@Data
public class Person {

    @Id @GeneratedValue
    private int id;

    private String name;
    private int age;
}
