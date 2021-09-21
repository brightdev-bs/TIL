package com.mango;

/**
 * 8월 19일 복습.
 */
import java.util.Scanner;

public class Main{

    public int factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }

    public static void main(String args[]) {
        com.mango.ch7.Main T = new com.mango.ch7.Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print(T.factorial(n));
    }
}