package com.mango;

/**
 * 8월 19일 복습.
 */
import java.util.Scanner;

public class Main{
    int[] arr = new int[10001];
    public int fibo(int n) {
        if(arr[n] != 0) return arr[n];
        if(n == 1 || n == 2) return arr[n] = 1;
        else {
            return arr[n] = fibo(n-1) + fibo(n-2);
        }
    }

    public static void main(String args[]) {
        com.mango.ch7.Main T = new com.mango.ch7.Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.print(T.fibo(i) + " ");
        }
    }
}