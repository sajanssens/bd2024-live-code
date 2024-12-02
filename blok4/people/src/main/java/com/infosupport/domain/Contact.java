package com.infosupport.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class Contact {
    @Id @GeneratedValue
    private int id;

    private String firstName;
    private String surname;
    private String email;
}
