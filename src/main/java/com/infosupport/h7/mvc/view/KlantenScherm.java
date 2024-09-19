package com.infosupport.h7.mvc.view;

import com.infosupport.h7.mvc.model.domain.Client;

import java.util.List;

import static com.infosupport.h7.mvc.Util.prompt;
import static com.infosupport.h7.mvc.Util.readLine;
import static com.infosupport.h7.mvc.controller.Controller.controller;

public class KlantenScherm {

    // singleton design pattern begin -----------
    private static KlantenScherm self;

    private KlantenScherm() { }

    public static synchronized KlantenScherm klantenScherm() {
        if (self == null) self = new KlantenScherm();
        return self;
    }
    // singleton design pattern end -------------

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Klant toevoegen]");
            System.out.println("(2) [Klanten raadplegen]");
            System.out.println("(x) [Terug]");

            switch (readLine()) {
                case "1" -> add();
                case "2" -> show();
                case "x" -> {
                    return;
                }
                default -> System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    private void show() {
        System.out.println("Dit zijn alle klanten:");
        List<Client> clients = controller().showAllClients();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void add() {
        String name = prompt("Geef de naam: ");
        Client addedClient = controller().addClient(name);
        System.out.println("Klant toegevoegd! " + addedClient);
    }
}
