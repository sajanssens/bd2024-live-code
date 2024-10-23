package com.infosupport;

import com.infosupport.dao.PersonDao;
import com.infosupport.domain.Person;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");

    private static PersonDao dao = new PersonDao();

    public static void main(String[] args) {
        Person bram = Person.builder().name("Bram").age(45).build();

        dao.create(bram);
        Person p = dao.read(1);

        System.out.println(p);
    }
}
