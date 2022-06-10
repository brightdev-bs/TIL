package dummy.chapter10;

import java.util.Arrays;
import java.util.Scanner;

public class Ch10_5_dy {
    public static int[] dy;
    public static int[] coin;

    public static void solution(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= 15; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]]) + 1;
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
        dy[0] = 0;

        solution(n);

        System.out.println(dy[m]);
    }
}
