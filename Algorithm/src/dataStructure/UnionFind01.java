package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionFind01 {

    public static int[] unf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(); // n = 학생 수, m = 숫자쌍

        unf = new int[n+1];
        for(int i = 0; i <= n; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        if(find(unf[a]) == find(unf[b])) System.out.println("YES");
        else System.out.println("NO");

    }

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int na = find(a);
        int nb = find(b);
        if(na != nb) unf[na] = nb;
    }
}
