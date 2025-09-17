package project.tests;

import framework.assertions.AssertException;
import framework.assertions.Assertions;
import framework.marker.Test;
import project.function.Calculator;

public class CalculatorLineTest {

    @Test
    public void testSumLine() throws AssertException {
        String result = Calculator.sumLine(2, 5);
        Assertions.contains(result, "2+5");
    }

    @Test
    public void testSubtractLine() throws AssertException {
        String result = Calculator.subtractLine(2, 5);
        Assertions.contains(result, "2-5");
    }

    @Test
    public void testMultiplyLine() throws AssertException {
        String result = Calculator.multiplyLine(2, 5);
        Assertions.contains(result, "2*5");
    }
}