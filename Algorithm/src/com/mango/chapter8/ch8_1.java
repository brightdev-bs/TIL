package com.mango.chapter8;

import java.util.Scanner;

public class ch8_1 {
    public static int[] ch;
    public static int[] arr;
    public static int n;
    static int total = 0;
    static boolean flag = false;
    static String answer = "NO";

    public static void DFSAMAZONE(int v, int sum) {
        if(flag) return;
        if(v == n) {
            if(sum == total - sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFSAMAZONE(v+1, sum + arr[v]);
            DFSAMAZONE(v+1, sum);
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        ch = new int[n+1];
        DFSAMAZONE(0, 0);
        System.out.println(answer);
    }
}
