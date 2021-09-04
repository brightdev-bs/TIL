package com.mango.chapter8;

import java.util.Scanner;

public class Ch8_9 {
    static int[] arr;
    static int[] ch;
    static int n,m;

    public static void DFS(int length, int start) {
        if(length == m) {
            for(int i = 1; i < ch.length; i++) {
                if(ch[i] != 0) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = start; i < ch.length; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(length + 1, start+i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];
        DFS(0,1);
    }
}
