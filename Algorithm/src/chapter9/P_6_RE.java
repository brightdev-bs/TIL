package chapter9;

import java.util.Scanner;

public class P_6_RE {

    public static int[] unf;

    public static int find(int num) {
        if(unf[num] == num) return num;
        else return unf[num] = find(unf[num]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fb] = fa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n+1];
        for(int i = 0; i <= n; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        int fa = find(a);
        int fb = find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
