package chapter10;

import java.util.Scanner;

public class Ch10_6 {
    public static int n,m;
    public static int[][] arr;
    public static int[] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dy = new int[m+1];

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            for(int j = m; t <= j; j--) {
                dy[j] = Math.max(dy[j], dy[j-t] + s);
            }
        }

        System.out.println(dy[m]);
    }
}
