package com.example.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboTest {

    @Test
    public void testFibonacchi() {
        int cases[][] = {{0, 0}, {1, 1}, {2, 1}, {3, 2} };
        for (int i = 0; i < cases.length; i++) {
            assertEquals(cases[i][1], fib(cases[i][0]));
        }
    }





    private int fib(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;
        return fib(num - 1) + fib(num - 2);
    }
}
