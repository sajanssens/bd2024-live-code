package com.infosupport.h10;

import java.math.BigDecimal;

// SOLID principles:
// S
// Open closed: een klasse mag je niet veranderen maar wel uitbreiden (extenden)
// L
// Interface segregation: maak liever meerdere kleine interfaces dan één grote
// Dependency Inversion: zie plaatje Studio/Effecten.

public interface Taxable {

    boolean hasSalary();

    public abstract BigDecimal calculateIncomeTax(int level);
}
