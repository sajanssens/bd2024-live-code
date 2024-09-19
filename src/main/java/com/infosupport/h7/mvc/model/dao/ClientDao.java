package com.infosupport.h7.mvc.model.dao;

import com.infosupport.h7.mvc.Database;
import com.infosupport.h7.mvc.model.domain.Client;

import java.util.List;

public class ClientDao {

    // singleton design pattern begin -----------
    private static ClientDao self;

    private ClientDao() { }

    public static synchronized ClientDao clientDao() {
        if (self == null) self = new ClientDao();
        return self;
    }
    // singleton design pattern end -------------

    public Client save(String name) {
        Client c = new Client();
        c.setName(name);
        Database.add(c);
        return c;
    }

    public List<Client> getAll() {
        return Database.clients;
    }
}
