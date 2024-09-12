package com.infosupport.h3;

public enum CompassPoint {
    NORTH, EAST, SOUTH, WEST
}

class CompassPointAsClass {
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
}

class UseThem {
    public void doe() {
        CompassPoint n = CompassPoint.NORTH;
        switch (n) {
            case NORTH:
                System.out.println("BRRRR...");
            case SOUTH:
                System.out.println("Warm...");
        }
    }
}
