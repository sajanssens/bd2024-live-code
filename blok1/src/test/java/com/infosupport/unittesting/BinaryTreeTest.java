package com.infosupport.unittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void givenEmptyTreeWhenLengthThenItShouldBe0() {
        // Arrange
        var sut = BinaryTree.empty();

        // Act
        var result = sut.length();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void givenTreeWithOneItemWhenLengthThenItShouldBe1() {
        var tree = BinaryTree.<Integer>empty();
        var sut = tree.add(1);

        var result = sut.length();

        assertEquals(1, result);
    }

    @Test
    public void givenEmptyTreeWhenAddingAnItemThenLengthShouldRemain0(){
        var sut = BinaryTree.<String>empty();
        sut.add("1");

        var result = sut.length();

        assertEquals(0, result);
    }
}
