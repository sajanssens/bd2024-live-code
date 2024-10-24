package com.infosupport;

import com.infosupport.dao.PersonDao;
import com.infosupport.domain.Person;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
    private static final PersonDao dao = new PersonDao(emf);

    public static void main(String[] args) {
        // Logging demo: ---------------
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO"); // jip en janneke logging voor de helpdesk
        log.debug("DEBUG"); // technische logging voor developers
        log.trace("TRACE"); // technische detail logging voor developers

        // JPA: ---------------
        Person bram = Person.builder().name("Bram").age(45).build();

        dao.create(bram);

        Person p1 = dao.read(1);
        log.debug("p1=" + p1);

        bram.setName("Bram Janssens");
        dao.update(bram);

        dao.updateName(bram.getId(), "Mieke Janssens - bij de Vaate");

        Person p2 = dao.read(1);
        log.debug("p2=" + p2);

        dao.delete(bram);
    }
}
