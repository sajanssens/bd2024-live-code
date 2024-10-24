package com.infosupport.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    // @Temporal(value = DATE)
    // private Date birthday;

    // Better:
    private LocalDate birthdate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Department worksAt;

    @ManyToOne
    private Clearance clearance;
}
