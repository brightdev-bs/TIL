package com.mango.chapter8;

import java.util.Scanner;

public class ch8_2 {
    public static int[] arr;
    public static int kg; // c
    public static int n;
    public static int answer = 0;

    public static void DFS(int cnt, int sum) {
        if(cnt == n) {
            int tmp = sum + arr[cnt];
            if(tmp <= kg && answer < tmp) {
                answer = tmp;
            } else if(sum < kg && answer < sum) {
                answer = sum;
            }
        }
        else {
            DFS(cnt+1, sum + arr[cnt]);
            DFS(cnt+1, sum);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        kg = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0);
        System.out.println(answer);
    }
}
