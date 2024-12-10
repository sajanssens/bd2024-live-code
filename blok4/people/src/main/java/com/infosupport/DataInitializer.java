package com.infosupport;

import com.infosupport.domain.Contact;
import com.infosupport.repositories.ContactRepo;
import com.infosupport.resources.CR;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Startup // to eagerly instantiate this bean
@Singleton
public class DataInitializer {

    @Inject @CR
    private ContactRepo repo;

    @PostConstruct
    public void onInit() {
        System.out.println("Initializing database...");
        repo.add(Contact.builder().firstName("Bram").surname("Janssens").build());
        repo.add(Contact.builder().firstName("Bram2").surname("Janssens2").build());
        System.out.println("Database initialized with initial data.");
    }
}
