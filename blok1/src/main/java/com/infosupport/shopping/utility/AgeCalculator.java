package com.infosupport.shopping.utility;

import java.time.LocalDate;

public class AgeCalculator {

    public static int calculate(LocalDate dateOfBirth, LocalDate now) {
        if (now.isBefore(dateOfBirth)) {
            throw new IllegalArgumentException(
                    String.format("You cannot be born in the future. (%s < %s)", now, dateOfBirth));
        }
        int age = now.getYear() - dateOfBirth.getYear();
        if (now.getMonth().getValue() < dateOfBirth.getMonth().getValue()) {
            age--;
        } else if (now.getMonth() == dateOfBirth.getMonth() && now.getDayOfMonth() < dateOfBirth.getDayOfMonth()) {
            age--;
        }
        return age;
    }
}
