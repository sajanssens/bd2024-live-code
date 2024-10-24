package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
@Data
public class Clearance {

    @Id @GeneratedValue
    private int id;
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "clearance")
    private List<Person> persons;
}
