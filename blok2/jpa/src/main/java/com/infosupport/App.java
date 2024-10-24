package com.infosupport;

import com.infosupport.dao.PersonDao;
import com.infosupport.domain.Department;
import com.infosupport.domain.Person;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

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
        Person bram = Person.builder().name("Bram").birthdate(LocalDate.of(1979, 8, 22)).age(45).build();

        dao.create(bram);

        Person p1 = dao.read(1);
        log.debug("p1=" + p1);

        bram.setName("Bram Janssens");
        dao.update(bram);

        dao.updateName(bram.getId(), "Mieke Janssens - bij de Vaate");

        Person p2 = dao.read(1);
        log.debug("p2=" + p2);

        Department iv = Department.builder().name("IV").build();
        bram.setWorksAt(iv);
        dao.update(bram);

        Person ramon = Person.builder().name("Ramon").worksAt(iv).build();
        Person nine = Person.builder().name("Nine").worksAt(iv).build();
        Person jan = Person.builder().name("Jan").worksAt(iv).build();
        dao.create(ramon);
        dao.create(nine);
        dao.create(jan);

        List<Person> ivMedewerkers = dao.findByDepartment(iv);
        log.info("Bij IV werken: {}", ivMedewerkers);

        // dao.delete(bram);
    }
}
