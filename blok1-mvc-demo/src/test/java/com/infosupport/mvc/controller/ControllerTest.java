package com.infosupport.mvc.controller;

import com.infosupport.mvc.model.dao.ClientDao;
import com.infosupport.mvc.model.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static com.infosupport.mvc.controller.Controller.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ControllerTest {

    private Controller sut;
    private ClientDao daoMock;

    @BeforeEach
    void setUp() {
        sut = controller();
        daoMock = mock(ClientDao.class);
        sut.setClientDao(daoMock);
    }

    @Test
    void name() {
        // given
        String name = "Bram";
        Mockito.when(daoMock.save(ArgumentMatchers.anyString())).thenReturn(new Client(1, name));

        // when
        Client addedClient = sut.addClient(name);

        // then
        assertEquals(1, addedClient.getId());
        assertEquals(name, addedClient.getName());
    }
}
