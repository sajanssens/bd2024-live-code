package com.infosupport.h7.mvc;

import com.github.javafaker.Faker;
import com.infosupport.h7.mvc.model.domain.Client;
import com.infosupport.h7.mvc.model.domain.House;
import com.infosupport.h7.mvc.model.domain.Laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Database {

    INSTANCE;

    public List<Client> clients = new ArrayList<>();
    public List<Laptop> laptops = new ArrayList<>();
    public List<House> houses = new ArrayList<>();

    private long nextClientId = 0;
    private long nextHouseId = 0;
    private final Faker FAKER = Faker.instance();

    Database() {
        // create some clients with house and laptops
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

    private House createClientHouse() {
        House clientHouse = new House(++nextHouseId);
        houses.add(clientHouse);
        return clientHouse;
    }

    private List<Laptop> createClientLaptops() {
        List<Laptop> clientLaps = new ArrayList<>();
        double betweenZeroAndThree = new Random().nextInt(3);
        for (int l = 0; l < betweenZeroAndThree; l++) {
            clientLaps.add(new Laptop(FAKER.company().buzzword()));
        }
        laptops.addAll(clientLaps);
        return clientLaps;
    }

    public void add(Client c) {
        c.setId(++nextClientId);
        clients.add(c);
    }
}
