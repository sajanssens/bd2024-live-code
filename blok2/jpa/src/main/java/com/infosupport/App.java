package com.infosupport;

import com.infosupport.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class App {

    private static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

    public static void main(String[] args) {
        Person bram = Person.builder().name("Bram").age(45).build();

        em.getTransaction().begin();
        em.persist(bram);
        em.getTransaction().commit();

        Person person = em.find(Person.class, 1);
        System.out.println(person);
    }
}
