package dummy.chapter8;

import java.util.Scanner;

public class Ch8_4_reminder {
    static int[] pm;
    static int n, m;

    public static void DFS(int idx) {
        if(idx == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                pm[idx] = i;
                DFS(idx+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pm = new int[m];
        for(int i = 1; i <= n; i++) {
            DFS(0);
        }
    }
}
