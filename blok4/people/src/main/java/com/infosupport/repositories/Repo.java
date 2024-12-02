package com.infosupport.repositories;

import java.util.List;

public interface Repo<T> {
    List<T> findAll();
    List<T> search(String term);

    T add(T t);

    void remove(int id);

    T update(T t);

    T get(int id);
}
