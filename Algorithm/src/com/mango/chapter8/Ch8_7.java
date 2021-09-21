package com.mango.chapter8;

import java.util.Scanner;

public class Ch8_7 {
    public static int[][] arr = new int[35][35];

    public static int DFS(int first, int second) {
        if(arr[first][second] != 0) return arr[first][second];
        if(second == 0 || first == second) {
            return 1;
        }else {
            return arr[first][second] = DFS(first-1, second-1) + DFS(first-1, second);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(DFS(n,m));
    }
}
