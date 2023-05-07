package com.example.calculator;

public class Calculator {

    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) { return a - b;}

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static String divide(int a, int b) {
        if (b == 0) {
            System.out.println("b는 0이 될 수 없습니다.");
            return "N/A";
        }
        return String.valueOf(a / b);
    }

}
