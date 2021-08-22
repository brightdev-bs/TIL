package com.mango;

import java.util.*;

public class Main {
    public int fibo(int n) {
        if(n == 1 || n == 2)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        for(int n = 1; n <= 45; n++) {
            System.out.println(m.fibo(n));
        }
    }
}

