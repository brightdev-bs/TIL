package com.mango;

import java.util.Scanner;

public class Ch8_8 {
    public static int n,m;
    public static int[] a, b; // a는 조합 경우의 수, b는 요소의 정렬 순서
    public static int[][] memory;
    public static int[] ch;
    public static boolean flag = false;

    public static int combi(int x, int y) {
        if(memory[x][y] != 0) return memory[x][y];
        if(y == 0 || x == y) {
            return 1;
        }else {
            return memory[x][y] = combi(x -1, y -1) + combi(x -1, y);
        }
    }

    public static void DFS(int l, int sum) {
        if(flag) return;
        if(l == n) {
            if(sum == m) {
                for(int x : b) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        }else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    b[l] = i;
                    DFS(l+1, sum + a[l] * b[l]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n];
        b = new int[n];
        ch = new int[n+1];
        memory = new int[35][35];
        for(int i = 0; i < n; i++) {
            a[i] = combi(n-1, i);
        }

        DFS(0, 0);
    }
}
