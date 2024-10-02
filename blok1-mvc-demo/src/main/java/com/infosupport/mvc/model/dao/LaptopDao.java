package com.infosupport.mvc.model.dao;

import com.infosupport.mvc.model.domain.Laptop;

import java.util.List;

public class LaptopDao extends Dao<Laptop> {
    public LaptopDao(Class<Laptop> type) {
        super(type);
    }

    @Override Laptop create(Laptop laptop) {
        return null;
    }

    @Override List<Laptop> readAll() {
        return null;
    }

    @Override Laptop read(int id) {
        return null;
    }

    @Override Laptop update(Laptop laptop) {
        return null;
    }

    @Override void delete(Laptop laptop) {

    }
}
