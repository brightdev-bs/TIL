package com.mango.chapter8;

import java.util.Scanner;

public class ch8_5 {
    public static int n, m;
    public static int[] arr;
    public static int answer = 9999;

    public static void DFS(int index, int sum) {
        if(answer <= index) return;
        if(sum > m) return;
        if(sum == m) {
            answer = Math.min(answer, index);
        }else {
            for(int i = n - 1; 0 <= i; i--) {
                DFS(index+1, sum+arr[i]);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt();

        DFS(0, 0);
        System.out.println(answer);
    }
}
