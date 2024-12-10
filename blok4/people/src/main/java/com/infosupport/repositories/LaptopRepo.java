package com.infosupport.repositories;

import com.infosupport.domain.Laptop;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped // == singleton
public class LaptopRepo implements Repo<Laptop> {

    @Override public List<Laptop> findAll() {
        return List.of();
    }

    @Override public List<Laptop> search(String term) {
        return List.of();
    }

    @Override public Laptop add(Laptop laptop) {
        return null;
    }

    @Override public void remove(int id) {

    }

    @Override public Laptop update(Laptop laptop) {
        return null;
    }

    @Override public Laptop get(int id) {
        return null;
    }
}
