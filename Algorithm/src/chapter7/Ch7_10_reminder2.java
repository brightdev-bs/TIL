package chapter7;

import java.util.Scanner;

public class Ch7_10_reminder2 {
    static int[][] board;
    static int[] ch;
    static int n,m;
    static String s = "";

    public static void DFS(int idx) {
        if(idx == n) {
            System.out.println();
            s = 1 + " ";
        } else {
            for(int i = 1; i <= n; i++) {
                if(board[idx][i] == 1 && ch[i] == 0) {
                    System.out.println("idx : " + idx + ", i : " + i);
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 1;
        }

        ch[1] = 1;
        DFS(1);
    }
}
