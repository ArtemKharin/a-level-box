package ua.kharin.jadv.practice9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSumPositiveNumbers() {
        Assertions.assertEquals(5, calculator.sum(2, 3));
        Assertions.assertEquals(5, calculator.sum(5, 0));
        Assertions.assertEquals(5, calculator.sum(1, 4));
        Assertions.assertEquals(5, calculator.sum(4, 1));
    }

    @Test
    public void testSumNegativeNumbers() {
        Assertions.assertEquals(-5, calculator.sum(-2, -3));
        Assertions.assertEquals(-5, calculator.sum(-5, 0));
        Assertions.assertEquals(-5, calculator.sum(-1, -4));
        Assertions.assertEquals(-5, calculator.sum(-4, -1));
    }

    @Test
    public void testDivPositiveOnPositive() {
        Assertions.assertEquals(2, calculator.divWithoutFraction(8, 4), 0);
        Assertions.assertEquals(0, calculator.divWithoutFraction(1, 4), 0.1);
    }

    @Test
    public void testDivByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            Assertions.assertEquals(Double.MAX_VALUE, calculator.divWithoutFraction(1, 0), 0);
        });
    }

    @Test
    public void testIncrement(){
        Assertions.assertEquals(0, calculator.getCounter());
        Assertions.assertEquals(0, calculator.getAndIncrement());
        Assertions.assertEquals(1, calculator.getAndIncrement());
        calculator.getAndIncrement();
        calculator.getAndIncrement();
        calculator.getAndIncrement();
        Assertions.assertEquals(5, calculator.getAndIncrement());
        Assertions.assertEquals(6, calculator.getCounter());
        Assertions.assertEquals(6, calculator.getCounter());
    }
}