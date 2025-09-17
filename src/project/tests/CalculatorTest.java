package project.tests;

import framework.assertions.AssertException;
import framework.assertions.Assertions;
import framework.marker.Test;
import project.function.Calculator;

public class CalculatorTest {

    @Test
    public void testSum() throws AssertException {
        Assertions.equals(5, Calculator.sum(2, 3));
    }

    @Test
    public void testSubtract() throws AssertException {
        Assertions.equals(4, Calculator.subtract(5, 2));
    }

    @Test
    public void testMultiply() throws AssertException {
        Assertions.equals(6L, Calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() throws AssertException {
        Assertions.equals(2.0, Calculator.divide(6, 3));
    }
}