package com.mango.chapter8;

import java.util.Scanner;

public class Ch8_6 {
    public static int n, m;
    public static int[] arr,ch;

    public static void DFS(int length) {
        if(length == m) {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(length + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1];
        ch = new int[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
    }
}
