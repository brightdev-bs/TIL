package dummy.chapter8;

import java.util.Scanner;

public class Ch8_5_DFS {
    static int n,m, answer = Integer.MAX_VALUE;
    static int[] coins;
    static int[] memory;

    public static void DFS(int c, int count) {
        if(c < 0) return;
        if(count > answer) return;
        if(c == 0) {
            answer = Math.min(answer, count);
        } else {
            for(int i = n-1; 0 <= i; i--) {
                DFS(c-coins[i], count+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        m = sc.nextInt();
        memory = new int[m+1];

        DFS(m,0);

        System.out.println(answer);
    }
}
