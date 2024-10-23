package com.infosupport.dao;

import com.infosupport.domain.Person;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.infosupport.App.emf;

public class PersonDao {

    public void create(Person p) {
        EntityManager connection = createNewEntityManager();

        connection.getTransaction().begin();
        connection.persist(p);
        connection.getTransaction().commit();

        connection.close();
    }

    public Person read(int id) {
        EntityManager connection = createNewEntityManager();
        Person person = connection.find(Person.class, id);
        connection.close();
        return person;
    }

    private static EntityManager createNewEntityManager() {
        return emf.createEntityManager();
    }

    public List<Person> findAll() {
        EntityManager em = createNewEntityManager();
        List<Person> persons = em.createQuery("select p from Person p", Person.class)
                .getResultList();
        em.close();
        return persons;
    }

    public List<Person> findAllNamed() {
        EntityManager em = createNewEntityManager();
        List<Person> persons = em.createNamedQuery("findAll", Person.class)
                .getResultList();
        em.close();
        return persons;
    }

    public List<Person> findBy(String name) {
        try (EntityManager em = createNewEntityManager()) {
            List<Person> persons = em.createNamedQuery("findBy", Person.class)
                    .setParameter("n", name)
                    .getResultList();
            return persons;
        }
    }

    public void delete(Person p) {
        EntityManager connection = createNewEntityManager();
        connection.getTransaction().begin();
        connection.remove(p);
        connection.getTransaction().commit();
        connection.close();
    }

    public Person update(Person p) {
        EntityManager connection = createNewEntityManager();
        connection.getTransaction().begin();
        Person merge = connection.merge(p);
        connection.getTransaction().commit();
        connection.close();
        return merge;
    }
}
