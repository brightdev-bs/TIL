package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_5_복습 {
    static class Edge implements Comparable<Edge> {
        int vex, val;
        Edge(int vex, int val) {
            this.vex = vex;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }

    public static ArrayList<ArrayList<Edge>> arr = new ArrayList<>();
    public static int[] dis;

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curVex = curEdge.vex;
            int curVal = curEdge.val;
            for(Edge r : arr.get(curVex)) {
                if(dis[r.vex] > r.val + curVal) {
                    dis[r.vex] = r.val + curVal;
                    pq.offer(new Edge(r.vex, r.val + curVal));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            arr.get(a).add(new Edge(b, c));
        }

        solution(1);

        for(int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
