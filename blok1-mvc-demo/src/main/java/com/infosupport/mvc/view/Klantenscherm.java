package com.infosupport.mvc.view;

import com.infosupport.mvc.model.domain.Client;

import java.util.List;

import static com.infosupport.mvc.Util.prompt;
import static com.infosupport.mvc.Util.readLine;
import static com.infosupport.mvc.controller.Controller.controller;

public class Klantenscherm {

    // singleton design pattern begin -----------
    private static Klantenscherm self;

    private Klantenscherm() { }

    public static synchronized Klantenscherm klantenScherm() {
        if (self == null) self = new Klantenscherm();
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
