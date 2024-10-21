package com.infosupport.shopping.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    public void Calculate_On32ndBirthDay_Returns32() {
        int age = AgeCalculator.calculate(LocalDate.of(1978, 9, 27), LocalDate.of(2010, 9, 27));
        assertEquals(32, age);
    }
}
