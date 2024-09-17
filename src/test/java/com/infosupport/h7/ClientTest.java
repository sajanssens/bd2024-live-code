package com.infosupport.h7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientTest {

    private Client sut;

    @BeforeEach
    void setUp() {
        sut = new Client();
    }

    // met 1, 2, 3, ... hoofdletters
    // zonder hoofdletter
    // cijfers
    // sql injection
    // ""
    // null

    @Test
    void givenANameWithOneCapitalLetterWhenThisNameIsSetOnAClientThenThisIsSuccesful() {
        // given / arrange
        String name = "Bram";

        // when / act
        sut.setName(name);

        // then / assert
        assertEquals(sut.getName(), "Bram");
    }

    @Test
    void givenANameWithTwoCapitalLettersWhenThisNameIsSetOnAClientThenThisIsSuccesful() {
        // given / arrange
        String name = "BRam";

        // when / act
        sut.setName(name);

        // then / assert
        assertNull(sut.getName());
    }

    @Test
    void testNull() {
        // given / arrange
        String name = null;

        //                                                  when / act:
        // then / assert
        assertThrows(IllegalArgumentException.class, () -> sut.setName(name));
    }
}
