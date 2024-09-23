package com.infosupport.h7.mvc;

import com.github.javafaker.Faker;
import com.infosupport.h7.mvc.model.domain.Client;
import com.infosupport.h7.mvc.model.domain.House;
import com.infosupport.h7.mvc.model.domain.Laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {

    public static List<Client> clients = new ArrayList<>();
    public static List<Laptop> laptops = new ArrayList<>();
    public static List<House> houses = new ArrayList<>();

    private static long nextClientId = 0;
    private static long nextHouseId = 0;
    private static final Faker FAKER = Faker.instance();

    // create some clients with house and laptops
    static {
        for (int c = 0; c < 100; c++) {
            List<Laptop> clientLaps = createClientLaptops();
            House clientHouse = createClientHouse();

            clients.add(
                    new Client(
                            ++nextClientId,
                            FAKER.funnyName().name(),
                            clientHouse, clientLaps));
        }
    }

    private Database() { }

    private static House createClientHouse() {
        House clientHouse = new House(++nextHouseId);
        houses.add(clientHouse);
        return clientHouse;
    }

    private static List<Laptop> createClientLaptops() {
        List<Laptop> clientLaps = new ArrayList<>();
        double betweenZeroAndThree = new Random().nextInt(3);
        for (int l = 0; l < betweenZeroAndThree; l++) {
            clientLaps.add(new Laptop(FAKER.company().buzzword()));
        }
        laptops.addAll(clientLaps);
        return clientLaps;
    }

    public static void add(Client c) {
        c.setId(++nextClientId);
        clients.add(c);
    }
}
