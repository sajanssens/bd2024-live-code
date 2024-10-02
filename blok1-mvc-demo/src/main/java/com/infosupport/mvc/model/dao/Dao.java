package com.infosupport.mvc.model.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class Dao<T> {

    // if you need to do really do something with T, you have to pass the class of T as instance:
    private final Class<T> myType;

    public Dao(Class<T> type){
        this.myType = type;
    }

    T create(T t) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "INSERT INTO " + myType.getSimpleName() + " (id, name) VALUES (?, ?)";
        return myType.getConstructor().newInstance();
    }

    abstract List<T> readAll();

    abstract T read(int id);

    abstract T update(T t);

    abstract void delete(T t);
}
