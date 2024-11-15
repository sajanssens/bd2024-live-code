package com.infosupport.dao;

import com.infosupport.domain.Person;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonDaoTestContainersIT {

    private PersonDao sut;

    private static final MySQLContainer<?> mySQLContainer =
            new MySQLContainer<>("mysql:latest")
                    .withDatabaseName("testdb")
                    .withUsername("testuser")
                    .withPassword("testpass");

    @BeforeAll
    static void beforeAll() {
        mySQLContainer.start();
    }

    @BeforeEach
    void setUp() {
        System.setProperty("DB_URL", mySQLContainer.getJdbcUrl());
        System.setProperty("DB_USER", mySQLContainer.getUsername());
        System.setProperty("DB_PASSWORD", mySQLContainer.getPassword());

        sut = new PersonDao(Persistence.createEntityManagerFactory("MySQL-testcontainer"));
    }

    @AfterAll
    static void afterAll() {
        mySQLContainer.stop();
        mySQLContainer.close();
    }

    @Test
    void createPersonAndChangeName_isCommittedToTheDatabase() {
        Person john = Person.builder().name("John").build();

        sut.create(john);
        int id = john.getId();
        assertThat(id).isNotZero();

        sut.updateName(id, "John Doe");
        Person read = sut.read(id);
        assertThat(read.getName()).isEqualTo("John Doe");
    }
}
