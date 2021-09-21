package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch9_7_복습 {

    static class Edge implements Comparable<Edge> {
        int vex, vex2, cost;
        Edge(int v, int v2, int c) {
            vex = v;
            vex2 = v2;
            cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static int[] unf;
    public static ArrayList<Edge> list;

    public static int find(int v) {
        if(unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v+1];
        for(int i = 0; i <= v; i++) {
            unf[i] = i;
        }

        list = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a,b,c));
        }

        Collections.sort(list);
        int answer = 0;
        for(Edge tmp : list) {
            int fa = find(tmp.vex);
            int fb = find(tmp.vex2);
            if(fa != fb) {
                answer += tmp.cost;
                union(fa, fb);
            }
        }

        System.out.println(answer);
    }
}
