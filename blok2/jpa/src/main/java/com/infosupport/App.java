package com.infosupport;

import com.infosupport.dao.DepartmentDao;
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
    private static final PersonDao personDao = new PersonDao(emf);
    private static final DepartmentDao departmentDao = new DepartmentDao(emf);

    public static void main(String[] args) {
        // Logging demo: ---------------
        log.error("Dit is een fout!");
        log.warn("Waarschuwing...");
        log.info("Hier wat informatie over ..."); // jip en janneke logging voor de helpdesk
        log.debug("DEBUG"); // technische logging voor developers
        log.trace("TRACE"); // otechnische detail logging vor developers

        // JPA: ---------------
        Person bram = Person.builder().name("Bram").birthdate(LocalDate.of(1979, 8, 22)).age(45).build();

        personDao.create(bram);

        Person p1 = personDao.read(1);
        log.debug("p1=" + p1);

        bram.setName("Bram Janssens");
        personDao.update(bram);

        personDao.updateName(bram.getId(), "Mieke Janssens - bij de Vaate");

        Person p2 = personDao.read(1);
        log.debug("p2=" + p2);

        Department iv = Department.builder().name("IV").build();
        departmentDao.create(iv);
        bram.setWorksAt(iv);
        personDao.update(bram);

        Person ramon = Person.builder().name("Ramon").worksAt(iv).build();
        Person nine = Person.builder().name("Nine").worksAt(iv).build();
        Person jan = Person.builder().name("Jan").worksAt(iv).build();
        personDao.create(ramon);
        personDao.create(nine);
        personDao.create(jan);

        List<Person> ivMedewerkers = personDao.findByDepartment(iv);
        log.info("Bij IV werken: {}", ivMedewerkers);

        // dao.delete(bram);
    }
}
