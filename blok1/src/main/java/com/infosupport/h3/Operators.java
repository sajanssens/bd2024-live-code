package com.infosupport.h3;

public class Operators {
    public static void main(String[] args) {
        int a = 24; // 00011000
        int i = 16; // 00001111
        int j = i >> 1; // keep sign
        int k = i >>> 1; // add 0's to left side
        int m = ~i; // 11101111
        int n = a & i; // 00010000
        int o = a | i; // 00011000
        int p = a ^ i; // 00001000

        int waarheid = 42;
        int schoenmaat = 43;

        boolean isHetEchtWaar = (isaBoolean(waarheid) || isaBoolean1(schoenmaat));

        boolean groteVoeten = schoenmaat > 45 ? true : false;

        boolean groteVoeten2;
        if (schoenmaat > 45) {
            groteVoeten2 = true;
        } else {
            groteVoeten2 = false;
        }

        int getal = 2;
        getal = getal + 1;
        getal += 1;
        getal /= 1;
        getal *= 1; // getal == 4

        int oudeWaardeVanGetal = getal++; // getal == 5
        int nieuweWaardeVanGetal = ++getal; // getal == 6

        System.out.println(oudeWaardeVanGetal);
        System.out.println(nieuweWaardeVanGetal);
        System.out.println(getal);
    }

    private static boolean isaBoolean(int waarheid) {
        System.out.println("isaBoolean");
        return waarheid == 42;
    }

    private static boolean isaBoolean1(int schoenmaat) {
        System.out.println("isaBoolean1");
        return schoenmaat > 43;
    }
}
