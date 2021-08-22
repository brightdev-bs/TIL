package com.mango;

/**
 * 8월 19일 복습.
 */
import java.util.Scanner;

public class Main{

    public void recursive(int n) {
        if(n == 0) return;
        recursive(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String args[]) {
        com.mango.ch7.Main T = new com.mango.ch7.Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.recursive(n);
    }
}