package com.infosupport.mvc.model.dao;

import com.infosupport.mvc.Database;
import com.infosupport.mvc.model.domain.Client;

import java.util.List;

public class ClientDao {

    Database db = Database.INSTANCE;

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
        db.add(c);
        return c;
    }

    public List<Client> getAll() {
        return db.clients;
    }

    public void setDb(Database db) {
        this.db = db;
    }
}
