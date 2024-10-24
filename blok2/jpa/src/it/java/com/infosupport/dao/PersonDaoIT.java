package com.infosupport.dao;

import com.infosupport.domain.Person;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class PersonDaoIT {

    private PersonDao sut;

    @BeforeEach
    void setUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2");

        sut = new PersonDao(emf);
    }

    @Test
    void create_withEntityManager_callsTransactionPersistAndClose() {
        Person john = Person.builder().name("John").build();

        sut.create(john);
        int id = john.getId();
        assertThat(id).isNotZero();

        sut.updateName(id, "John Doe");
        Person read = sut.read(id);
        assertThat(read.getName()).isEqualTo("John Doe");
    }
}
