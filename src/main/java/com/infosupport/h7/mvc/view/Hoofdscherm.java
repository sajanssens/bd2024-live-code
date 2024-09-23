package com.infosupport.h7.mvc.view;

import static com.infosupport.h7.mvc.Util.readLine;
import static com.infosupport.h7.mvc.view.Klantenscherm.klantenScherm;

public class Hoofdscherm {
    // singleton design pattern begin -----------
    private static Hoofdscherm self;

    private Hoofdscherm() { }

    public static synchronized Hoofdscherm hoofdscherm() {
        if (self == null) self = new Hoofdscherm();
        return self;
    }
    // singleton design pattern end -------------
    public void start() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welkom bij CRM!");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Beheren klanten] ");
            System.out.println("(x) [Afsluiten] ");

            try {
                switch (readLine()) {
                    case "1" -> klantenScherm().start();
                    case "x" -> {
                        System.out.println("Tot ziens.");
                        return;
                    }
                    default -> System.out.println("Ongeldige keuze; probeer opnieuw.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (RuntimeException t) {
                System.out.println("Er ging iets mis... Probeer het opnieuw. ");
                System.out.println("Foutmelding: " + t.getMessage());
                t.printStackTrace();
            } catch (Exception e) {
                System.out.println("Er ging iets vreselijk mis... ");
                System.out.println("Foutmelding: " + e.getMessage());
                System.out.println("Neem contact op met de leverancier.");
                System.out.println("Tot ziens.");
            }
        }
    }
}
