package com.mango.chapter8;

import java.util.Scanner;

public class Ch8_10 {
    public static int[][] arr;
    public static int[] dx = { -1, 0, 0, 1 };
    public static int[] dy = { 0, 1, -1, 0 };
    public static int answer = 0;

    public static void DFS(int n, int m) {
        if(n == 7 && m == 7) {
            answer++;
            return;
        } else {
            for(int i = 0; i < dx.length; i++) {
                if(1 <= n && n <= 7 && 1 <= m && m <= 7 && arr[n][m] == 0) {
                    arr[n][m] = 1;
                    DFS(n+dx[i], m+dy[i]);
                    arr[n][m] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        arr = new int[8][8];

        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        DFS(1,1);
        System.out.println(answer);
    }
}
