package com.infosupport.repositories;

import com.infosupport.domain.Contact;
import com.infosupport.resources.CR;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped // == singleton
// @Any @Default impliciet aanwezig
@CR
public class ContactRepo implements Repo<Contact> {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;

    @Override
    public List<Contact> findAll() {
        return em.createQuery("Select c from Contact c", Contact.class).getResultList();
    }

    @Override public List<Contact> search(String term) {
        return List.of();
    }

    @Transactional
    @Override public Contact add(Contact contact) {
        return em.merge(contact);
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
