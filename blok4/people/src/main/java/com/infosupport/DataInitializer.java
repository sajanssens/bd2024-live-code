package com.infosupport;

import com.infosupport.domain.Contact;
import com.infosupport.repositories.ContactJPARepo;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.annotation.PostConstruct;


@Startup
@Singleton
public class DataInitializer {

    @Inject
    private ContactJPARepo repo;

    @PostConstruct
    public void init() {
        System.out.println("Initializing database...");
        repo.add(Contact.builder().firstName("Bram").surname("Janssens").build());
        repo.add(Contact.builder().firstName("Bram2").surname("Janssens2").build());
        System.out.println("Database initialized with initial data.");
    }
}
