package com.infosupport.mvc.model.dao;

import com.infosupport.mvc.Database;
import com.infosupport.mvc.model.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static com.infosupport.mvc.model.dao.ClientDao.clientDao;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientDaoTest {

    private ClientDao sut;
    private Database dbMock;

    @BeforeEach
    void setUp() {
        sut = clientDao();
        dbMock = Mockito.mock(Database.class);
        sut.setDb(dbMock);
    }

    @Test
    void save() {
        Client bram = sut.save("Bram");

        assertEquals("Bram", bram.getName());
        Mockito.verify(dbMock).add(ArgumentMatchers.any(Client.class));
    }
}
