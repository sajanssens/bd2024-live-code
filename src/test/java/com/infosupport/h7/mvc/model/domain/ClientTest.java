package com.infosupport.h7.mvc.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    // stap 1:
    private Client sut;

    @BeforeEach
    void setUp() {
        sut = new Client();
    }

    // stap 2: testmethode maken
    @Test
    void givenNewNameIsNullWhenThisIsSetOnAClientThenAnIllegalArgumentExceptionIsThrown() {
        // hoe kan ik ervoor zorgen dat de setName in de eerste if terecht komt?

        // given: je testdata klaarzetten
        String newName = null;

        //                                             when: ik een methode aanroep

        // then: assert that an expected value is the actual value
        assertThrows(IllegalArgumentException.class, () -> sut.setName(newName));
    }

    @Test
    void givenAClientWhenToStringIsCalledThenThisContainsACurlyBracket() {
        // given
        // see BeforeEach

        // when
        String actual = sut.toString();

        assertTrue(actual.contains("{"));
    }
}
