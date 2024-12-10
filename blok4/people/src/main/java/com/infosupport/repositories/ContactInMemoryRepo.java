package com.infosupport.repositories;

import com.infosupport.domain.Contact;
import com.infosupport.domain.ContactDto;
import com.infosupport.resources.CR;
import jakarta.enterprise.context.ApplicationScoped; // CDI = Contexts & Dependency Injection
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

@ApplicationScoped // == singleton
public class ContactInMemoryRepo implements Repo<Contact> {

    private static final ArrayList<Contact> contacts = new ArrayList<>(List.of(
            new Contact(1, "Bram1", "Janssens", "45@42.com"),
            new Contact(2, "Bram2", "Janssens", "45@42.com"),
            new Contact(3, "Bram3", "Janssens", "45@42.com"),
            new Contact(4, "Bram4", "Janssens", "45@42.com"))
    );

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public List<Contact> search(String term) {
        return contacts.stream()
                .filter(c -> c.getFirstName().contains(term) ||
                        c.getSurname().contains(term) ||
                        c.getEmail().contains(term))
                .toList();
    }

    @Override
    public Contact add(Contact c) {
        return null;
    }

    // @Override
    public Contact add(ContactDto contactDto) {
        int maxId = contacts.stream()
                .max(comparingInt(Contact::getId))
                .map(Contact::getId)
                .orElse(0);

        Contact newContact = new Contact(++maxId, contactDto.firstName(), contactDto.surname(), contactDto.email());

        contacts.add(newContact);
        return newContact;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Contact update(Contact aangifte) {
        return null;
    }

    @Override
    public Contact get(int id) {
        return null;
    }
}
