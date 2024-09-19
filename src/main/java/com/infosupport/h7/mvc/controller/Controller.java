package com.infosupport.h7.mvc.controller;

import com.infosupport.h7.mvc.model.domain.Client;

import java.util.List;

import static com.infosupport.h7.mvc.model.dao.ClientDao.clientDao;

public class Controller {

    // singleton design pattern begin -----------
    private static Controller self;

    private Controller() { }

    public static synchronized Controller controller() {
        if (self == null) self = new Controller();
        return self;
    }
    // singleton design pattern end -------------

    public Client addClient(String name) {
        return clientDao().save(name);
    }

    public List<Client> showAllClients() {
        return clientDao().getAll();
    }
}
