package com.infosupport.h7.mvc;

import java.lang.reflect.InvocationTargetException;

import static com.infosupport.h7.mvc.view.Hoofdscherm.hoofdscherm;

public class Start {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        hoofdscherm().start();
    }
}
