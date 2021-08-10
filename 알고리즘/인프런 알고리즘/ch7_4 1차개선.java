package com.mango;

import java.util.*;

public class Main {
    static int[] fiboArr;
    public int fibo(int n) {
        if(n == 1 || n == 2)
            return fiboArr[n] = 1;
        else
            return fiboArr[n] = fibo(n-2) + fibo(n-1);
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        int n = 45;

        fiboArr = new int[n+1];

        m.fibo(n);

        for(int i = 1; i <= n; i++) {
            System.out.println(fiboArr[i]+" ");
        }
    }
}

