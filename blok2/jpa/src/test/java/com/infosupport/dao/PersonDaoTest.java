package com.infosupport.dao;

import com.infosupport.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonDaoTest {

    @Mock EntityManagerFactory emf;
    @InjectMocks PersonDao sut;

    // Some other mock object to use:
    @Mock EntityManager emMock;
    @Mock EntityTransaction transactionMock;

    @Test
    void create_withEntityManager_callsTransactionPersistAndClose() {
        // Arrange
        when(emf.createEntityManager()).thenReturn(emMock);
        when(emMock.getTransaction()).thenReturn(transactionMock);
        // when(emMock.persist(any())).thenReturn(transactionMock);

        // Act
        sut.create(new Person());

        // Assert
        verify(transactionMock).begin();
        verify(emMock).persist(any());
        verify(transactionMock).commit();
        verify(emMock).close();
    }
}
