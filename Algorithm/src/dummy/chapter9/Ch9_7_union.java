package dummy.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch9_7_union {
    static class Edge implements Comparable<Edge> {
        int v1, v2, val;
        Edge(int v1, int v2, int val) {
            this.v1 = v1;
            this.v2 = v2;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }

    public static ArrayList<Edge> list = new ArrayList<>();
    public static int[] unf;

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

        int city = sc.nextInt();
        int path = sc.nextInt();

        unf = new int[city+1];
        for(int i = 0; i <= city; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < path; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a,b,c));
        }

        Collections.sort(list);

        int answer = 0;

        for(Edge tmp : list) {
            int fv1 = find(tmp.v1);
            int fv2 = find(tmp.v2);
            if(fv1 != fv2) {
                answer += tmp.val;
                union(tmp.v1, tmp.v2);
            }
        }

        System.out.println(answer);
    }
}
