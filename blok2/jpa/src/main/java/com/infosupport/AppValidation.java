package com.infosupport;

import com.infosupport.domain.Person;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppValidation {

    private static final Logger log = LoggerFactory.getLogger(AppValidation.class);
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static void main(String[] args) {
        Person jan = Person.builder().name("Jan").build();

        // Programmatic validation:
        var violations = validator.validate(jan);
        violations.forEach(v -> log.error("Validation error:  {} {}, {}.", v.getPropertyPath(), v.getMessage(), v.getRootBeanClass()));

        notNullValidate(""); // OK
        notNullValidate(null); // NOK
    }

    private static void notNullValidate(@NotNull String s) {
        var violations = validator.validate(s);
    }
}
