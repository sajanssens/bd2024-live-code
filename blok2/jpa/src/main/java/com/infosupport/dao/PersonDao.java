package com.infosupport.dao;

import com.infosupport.domain.Department;
import com.infosupport.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonDao {

    private static Logger log = LoggerFactory.getLogger(PersonDao.class);
    // ...
    private EntityManagerFactory emf;
    // Type object;

    public PersonDao(EntityManagerFactory emf /*, Type eenObject*/) {
        this.emf = emf;
        // this.object = eenObject;
    }

    public void create(Person p) {
        EntityManager em = emf.createEntityManager();

        log.debug("Creating person: " + p);
        log.debug("begin transaction...");

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        log.debug("end transaction...");

        em.close();
    }

    public Person read(int id) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("select p from Person p", Person.class)
                .getResultList();
        em.close();
        return persons;
    }

    public List<Person> findAllNamed() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createNamedQuery("findAll", Person.class)
                .getResultList();
        em.close();
        return persons;
    }

    public List<Person> findBy(String name) {
        try (EntityManager em = emf.createEntityManager();) {
            List<Person> persons = em.createNamedQuery("findBy", Person.class)
                    .setParameter("n", name)
                    .getResultList();
            return persons;
        }
    }

    public void delete(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // does not work: removes a detached instance
        // connection.remove(p);

        // Solution: first find by id, then remove THAT entity (that's managed)
        Person person = em.find(Person.class, p.getId());
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Person update(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person merge = em.merge(p);
        em.getTransaction().commit();
        em.close();
        return merge;
    }

    public Person updateName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.getTransaction().begin();
        person.setName(name);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    public List<Person> findByDepartment(Department d) {
        return emf.createEntityManager()
                .createQuery("select p from Person p where p.worksAt = :d", Person.class)
                .getResultList();
    }
}
