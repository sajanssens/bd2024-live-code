package com.infosupport.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @NoArgsConstructor
@Builder @AllArgsConstructor
@Data
public class Course {

    @Id @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(mappedBy = "courses") @Builder.Default
    private List<Person> trainees = new ArrayList<>();
}
