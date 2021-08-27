package com.mango;

import java.util.Scanner;

public class Ch8_7_remind {
    public static int n, m;
    public static int[][] arr;

    public static int DFS(int n2, int m2) {
        if(arr[n2][m2] != 0) return arr[n2][m2];
        if(m2 == 0 || n2 == m2) {
            return 1;
        } else {
            return arr[n2][m2] = DFS(n2-1, m2-1) + DFS(n2-1, m2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[34][34];

        System.out.println(DFS(n,m));
    }
}
