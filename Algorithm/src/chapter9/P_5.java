package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P_5 {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static class Edge implements Comparable<Edge> {
        int vertex, cost;

        public Edge(int first, int second) {
            this.vertex = first;
            this.cost = second;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int cp = tmp.vertex;
            int currentCost = tmp.cost;
            if(currentCost > dis[cp])
            for(Edge ob : graph.get(cp)) {
                if(dis[ob.vertex] > ob.cost) {
                    dis[ob.vertex] = ob.cost + currentCost;
                    pq.offer(new Edge(ob.vertex, currentCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<ArrayList<Edge>>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c=  sc.nextInt();
            graph.get(a).add(new Edge(b,c));
        }
    }
}
