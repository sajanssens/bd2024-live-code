package com.infosupport.unittesting;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static com.infosupport.unittesting.MyMath.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyMathTest {

    @Test
    public void fac_given1_eq1(){
        assertEquals(1, fac(1));
    }

    @Test
    public void fac_given2_eq2(){
        assertEquals(2, fac(2));
    }

    @Test
    public void fac_given3_eq6(){
        assertEquals(6, fac(3));
    }

    @Test
    public void fac_givenMinus1_throwsInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> fac(-1));
    }

    @Test
    public void fac_givenMinus1_throwsInvalidArgumentWithCorrectMessage() {
        var actualException = assertThrows(IllegalArgumentException.class, () -> fac(-1));
        assertEquals(actualException.getMessage(), "fac(-1) is not supported (only positive numbers)");
    }

    @Test
    public void fac_given12_returns479001600() {
        assertEquals(479001600  , fac(12));
    }

    @Test
    public void fac_given0_returns1() {
        assertEquals(1, fac(0));
    }
    @Test
    public void fac_given13_throwsArithmeticException() {
        var actualException = assertThrows(ArithmeticException.class, () -> fac(13));
        assertEquals(actualException.getMessage(), "fac(13) is not supported (max is 12)");
    }

    @Test
    public void fac_givenBigIntNegativeNumber_throwsIllegalArgumentException() {
        var actualException = assertThrows(IllegalArgumentException.class, () -> fac(new BigInteger("-2")));
        assertEquals(actualException.getMessage(), "fac(-2) is not supported (only positive numbers)");
    }

    @Test
    public void fac_givenBigInt0_returns1() {
        assertEquals(BigInteger.ONE, fac(BigInteger.ZERO));
    }

    @Test
    public void fac_givenBigInt1_returns1() {
        assertEquals(BigInteger.ONE, fac(BigInteger.ONE));
    }

    @Test
    public void fac_givenBigInt2_returns2() {
        assertEquals(BigInteger.TWO, fac(BigInteger.TWO));
    }

    @Test
    public void fac_givenBigInt20_returns2432902008176640000 () {
        assertEquals(new BigInteger("2432902008176640000"), fac(new BigInteger("20")));
    }

    @Test
    public void areaOfCircle_givenR2_eq12566() {
        assertEquals(areaOfCircle(2), 12.566370614359172);
    }

    @Test
    public void throwDice_givenRandom0_returns1() {
        var randomProviderMock = new RandomProviderMock(0);
        var myMath = new MyMath(randomProviderMock);
        assertEquals(myMath.throwDice(), 1);
    }

    @Test
    public void throwDice_givenRandom015_returns1() {
        var randomProviderMock = new RandomProviderMock(0.15);
        var myMath = new MyMath(randomProviderMock);

        assertEquals(myMath.throwDice(), 1);
    }

    @Test
    public void throwDice_givenRandom01666667_returns2() {
        var myMath = new MyMath(new RandomProviderMock(.1666667));

        assertEquals(myMath.throwDice(), 2);
    }

    private static class RandomProviderMock extends RandomProvider {

        double randomValue;
        RandomProviderMock(double randomValue) {
            this.randomValue = randomValue;
        }

        @Override
        public double random() {
            return this.randomValue;
        }
    }
}
