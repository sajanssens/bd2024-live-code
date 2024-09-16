package com.infosupport.h3;

public enum CompassPoint {
    NORTH("Noord", 1), EAST("Oost", 2), SOUTH("Zuid", 3), WEST("West", 4);

    private final String nameNL;
    private final int id;

    CompassPoint(String nameNL, int i) {
        this.nameNL = nameNL;
        this.id = i;
    }

    public String getNameNL() {
        return nameNL;
    }
}

class CompassPointAsClass {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private final String nameNL;

    private CompassPointAsClass(String nameNL) {
        this.nameNL = nameNL;
    }
}

class UseThem {
    public void doe() {
        CompassPoint n = CompassPoint.NORTH;
        switch (n) {
            case NORTH:
                System.out.println("BRRRR..." + n.getNameNL());
            case SOUTH:
                System.out.println("Warm...");
        }
    }
}
