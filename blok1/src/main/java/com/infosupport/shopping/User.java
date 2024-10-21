package com.infosupport.shopping;

import java.time.LocalDate;
import com.infosupport.shopping.utility.AgeCalculator;

public record User(String name, LocalDate dateOfBirth, String accountNumber) {
    public int getAge() {
        return AgeCalculator.calculate(dateOfBirth, LocalDate.now());
    }

}
