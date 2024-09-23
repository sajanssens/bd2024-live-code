package com.infosupport.h1;

import org.junit.jupiter.api.Test;

import static com.infosupport.h1.FactorialDemo.factorial;
import static com.infosupport.h1.FactorialDemo.factorialFunctionalStyle;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialDemoTest {

    @Test
    void testFactorial() {
        int result = factorial(5);
        assertEquals(120, result);
    }

    @Test
    void testFactorialFunctionalStyle() {
        int result = factorialFunctionalStyle(5);
        assertEquals(120, result);
    }
}
