package com.infosupport.h10;

import java.math.BigDecimal;

// SOLID principles:

// Single responsibility: every "thing" must have one responsibility (i.e. only one reason to change).
// Open closed: een klasse mag je niet veranderen maar wel uitbreiden (extenden)
// Liskov Substitution: daar waar een instance van een type wordt verwacht, mag je ook altijd een instance van het subtype meegeven.
// Interface segregation: maak liever meerdere kleine interfaces dan één grote
// Dependency Inversion: zie plaatje Studio/Effecten.

public interface Taxable {

    static final long defaultsalary = 30_000;

    boolean hasSalary();

    BigDecimal calculateIncomeTax(int level);

    default int som(int x, int y) {
        return x + y;
    }
}
