package chapter9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_7_복습2 {
    static class Edge implements Comparable<Edge> {
        int vex, cost;
        Edge(int v, int c) {
            vex = v;
            cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static int[] ch;
    public static ArrayList<ArrayList<Edge>> arr;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v+1];

        arr = new ArrayList<>();

        for(int i = 0; i <= v; i++) {
            arr.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.get(a).add(new Edge(b,c));
            arr.get(b).add(new Edge(a,c));
        }

        solution(1);

        System.out.println(answer);
    }

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int ev = tmp.vex;
            if(ch[ev] == 0) {
                ch[ev] = 1;
                answer += tmp.cost;
                for(Edge ob : arr.get(ev)) {
                    if(ch[ob.vex] == 0) {
                        pq.add(ob);
                    }
                }
            }

        }
    }
}
