package chapter8;

import java.util.Scanner;

public class Ch8_8 {

    public static int n, m;
    public static int[] ch, answer, b;
    public static int[][] dy;
    public static boolean flag = false;

    public static int setSeq(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = setSeq(n-1, r-1) + setSeq(n-1,r);
    }

    public static void DFS(int L, int sum) {
        if(flag) return;
        if(L == n) {
            if(sum == m) {
                for(int n : answer) {
                    System.out.print(n + " ");
                }
                flag = true;
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = i;
                    DFS(L+1, sum + answer[L] * b[L]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        dy = new int[n+1][n+1];
        b = new int[n+1];
        ch = new int[n+1];
        answer = new int[n];

        for(int i = 0; i < n; i++) {
            b[i] = setSeq(n-1, i);
        }
        DFS(0, 0);
    }
}
