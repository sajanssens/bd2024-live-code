package com.infosupport.h10.soundmodule;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public class Studio {

    private List<Effect> effectList = new ArrayList<Effect>();

    void run() {
        for (Effect effect : this.effectList) {
            effect.process();
        }
    }

    void load(Effect... effects) {
        this.effectList.addAll(stream(effects).toList());
    }
}

interface Effect {
    void process();
}

class Reverb implements Effect {

    @Override public void process() {
        System.out.println("...reverberating...");
    }
}

class Delay implements Effect {

    @Override public void process() {
        System.out.println("Echo Echo Echo Echo ...");
    }
}

class Distort implements Effect {

    @Override public void process() {
        System.out.println("Roooooooooooooooooooooooooooy!#&*#%^@&* ...");
    }
}

class Start {
    public static void main(String[] args) {
        Studio studio = new Studio();
        studio.load(new Distort(), new Reverb(), new Delay());
        studio.run();
    }
}
