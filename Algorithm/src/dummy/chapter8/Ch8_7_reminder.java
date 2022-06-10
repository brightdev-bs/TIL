package dummy.chapter8;

import java.util.Scanner;

public class Ch8_7_reminder {
    public static int[][] ch;

    public static int DFS(int n, int r) {
        if(ch[n][r] != 0) return ch[n][r];
        if(n == r || n == 1 || r == 0) return 1;
        else {
            return ch[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n+1][n+1];

        System.out.println(DFS(n,m));
    }
}
