package dummy.chapter10;

import java.util.Scanner;

public class P_1_DP {

    static int[] dy;

    public static void solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dy = new int[n+1];
        solution(n);

        System.out.println(dy[n]);
    }
}
