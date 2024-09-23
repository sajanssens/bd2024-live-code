package com.infosupport.h7.mvc.model.dao;

import com.infosupport.h7.mvc.Database;
import com.infosupport.h7.mvc.model.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.infosupport.h7.mvc.model.dao.ClientDao.clientDao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ClientDaoTest {

    private ClientDao sut;
    private Database dbMock;

    @BeforeEach
    void setUp() {
        sut = clientDao();
        dbMock = mock(Database.class);
        sut.setDb(dbMock);
    }

    @Test
    void save() {
        Client bram = sut.save("Bram");

        assertEquals("Bram", bram.getName());
        verify(dbMock).add(any(Client.class));
    }
}
