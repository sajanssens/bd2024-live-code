package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
@Data
// @NamedQueries({
@NamedQuery(name = "findAll", query = "select p from Person p") //,
@NamedQuery(name = "findBy", query = "select p from Person p where name = :n")
// })
public class Person {

    @Id @GeneratedValue
    private int id;

    private String name;
    private int age;
}
