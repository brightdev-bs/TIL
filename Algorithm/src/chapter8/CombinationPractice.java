package chapter8;

import java.util.Scanner;

public class CombinationPractice {

    static int n,m;
    static int[] combi;

    public static void DFS(int L, int s) {
        if(L == m) {
            for (int n : combi) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];
        DFS(0,1);
    }
}
