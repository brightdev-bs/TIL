package chapter8;

import java.util.Scanner;

public class Ch8_7 {
    static int[][] ch;

    public static int DFS(int n, int r) {
        if(n == r || r == 0) return 1;
        if(ch[n][r] != 0) return ch[n][r];
        return ch[n][r] = DFS(n-1, r-1) + DFS(n-1,r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        ch = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }
}
