package chapter9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P_7 {

    static ArrayList<ArrayList<Edge>> list;
    static int[] dis, ch;
    static int answer = 0;

    static class Edge implements Comparable<Edge>{
        int v, c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void solution() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        while(!pq.isEmpty()) {
            Edge cv = pq.poll();
            if(ch[cv.v] == 0) {
                ch[cv.v] = 1;
                answer += cv.c;
            }
            for(Edge nv : list.get(cv.v)) {
                if(ch[nv.v] == 0) pq.add(nv);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v + 1];
        dis = new int[v + 1];
        for(int i = 0; i <= v; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b,c));
            list.get(b).add(new Edge(a,c));
        }

        solution();

        System.out.println(answer);
        

    }
}
