package com.mango.chapter8;

import java.util.Scanner;

public class ch8_3 {
    static int n, limit;
    static int answer = 0;
    static int[][] arr;

    public static void DFS(int index, int sum, int time) {
        if(index == n) {
            if(time <= limit && answer < sum) {
                answer = sum;
            }
        } else {
            DFS(index + 1, sum, time);
            DFS(index + 1, sum + arr[index][0], time + arr[index][1]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        limit = sc.nextInt();

        arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }
}
