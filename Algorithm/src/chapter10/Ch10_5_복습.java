package chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class Ch10_5_복습 {
    public static int[] coin, dy;

    public static void solution(int n, int m) {
        dy[0] = 0;
        for(int i = 0; i < coin.length; i++) {
            int max = 0;
            for(int j = coin[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+ 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        coin = new int[n];

        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        solution(n,m);

        System.out.println(dy[m]);
    }
}
