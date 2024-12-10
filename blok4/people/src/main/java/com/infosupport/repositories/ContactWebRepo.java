package com.infosupport.repositories;

import com.infosupport.domain.Contact;
import com.infosupport.util.ContactJsonServerClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped // == singleton
// @CR
public class ContactWebRepo implements Repo<Contact> {

    @RestClient ContactJsonServerClient http;

    @Override
    public List<Contact> findAll() {
        // Client http = ClientBuilder.newClient();
        // List<Contact> list =
        //         http.target("http://localhost:3000/contacts")
        //                 .request()
        //                 .header("Authorization", "Bearer fhsdfg84ru8ybhjvsifbjsfnisihvubj")
        //                 .get(List.class);
        List<Contact> list = http.getContacts();
        return list;
    }

    @Override public List<Contact> search(String term) {
        return List.of();
    }

    @Override public Contact add(Contact contact) {
        return null;
    }

    @Override public void remove(int id) {

    }

    @Override public Contact update(Contact contact) {
        return null;
    }

    @Override public Contact get(int id) {
        return null;
    }
}
