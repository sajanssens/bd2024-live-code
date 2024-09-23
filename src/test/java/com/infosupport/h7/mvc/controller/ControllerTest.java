package com.infosupport.h7.mvc.controller;

import com.infosupport.h7.mvc.model.dao.ClientDao;
import com.infosupport.h7.mvc.model.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.infosupport.h7.mvc.controller.Controller.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        when(daoMock.save(anyString())).thenReturn(new Client(1, name));

        // when
        Client addedClient = sut.addClient(name);

        // then
        assertEquals(1, addedClient.getId());
        assertEquals(name, addedClient.getName());
    }
}
