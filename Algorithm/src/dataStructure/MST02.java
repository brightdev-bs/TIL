package dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 크루스칼 알고리즘
public class MST02 {

    static int[] unf;

    static class Edge implements Comparable<Edge>{
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static int find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public static boolean union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);
        if(fv1 != fv2) {
            unf[fv1] = fv2;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(), e = sc.nextInt();
        unf = new int[v+1];
        for(int i = 0; i <= v; i++) {
            unf[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt(), v2 = sc.nextInt(), cost = sc.nextInt();
            list.add(new Edge(v1,v2,cost));
        }

        Collections.sort(list);

        int answer = 0;
        for(Edge edge : list) {
            if(union(edge.v1, edge.v2)) answer += edge.cost;
        }
        System.out.println(answer);
    }
}
