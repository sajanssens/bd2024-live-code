package com.infosupport.repositories;

import com.infosupport.domain.Contact;
import jakarta.data.repository.BasicRepository;
import jakarta.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactDataRepo extends BasicRepository<Contact, Integer> {
    List<Contact> findByFirstName(String firstName);

    Optional<Contact> findByEmail(String email);
}
