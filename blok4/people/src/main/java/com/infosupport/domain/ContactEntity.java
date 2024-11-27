package com.infosupport.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class ContactEntity {
    private int id;
    private String firstName;
    private String surname;
    private String email;
}
