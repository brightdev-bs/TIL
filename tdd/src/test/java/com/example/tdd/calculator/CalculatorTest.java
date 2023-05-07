package com.example.tdd.calculator;

import com.example.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    /**
     * 1. 더하기
     * 2. 뺄셈
     * 3. 곱하기
     * 4. 나누기
     */

    @Test
    public void plus() {
        int a = 1;
        int b = 2;
        assertEquals(3, Calculator.plus(a, b));
    }

    @Test
    public void minus() {
        int a = 3;
        int b = 5;
        assertEquals(-2, Calculator.minus(a, b));
    }

    @Test
    public void multiply() {
        int a = 1;
        int b = 20;
        assertEquals(20, Calculator.multiply(a, b));
    }

    @Test
    public void divide() {
        int a = 5;
        int b = 2;
        assertEquals(String.valueOf(a / b), Calculator.divide(a, b));
        assertEquals("N/A", Calculator.divide(5, 0));
    }
}
