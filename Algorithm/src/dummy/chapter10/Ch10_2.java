package dummy.chapter10;

import java.util.Scanner;

public class Ch10_2 {
    public static int[] dy;

    public static void solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n + 1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dy = new int[n + 2];

        solution(n);

        System.out.println(dy[n+1]);

    }
}
