package chapter9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_7_priq {
    static class Edge implements Comparable<Edge> {
        int vertex, cost;
        Edge(int v, int c) {
            vertex = v;
            cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static int[] ch;
    public static int answer = 0;
    public static ArrayList<ArrayList<Edge>> list;

    public static void solution(int v) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(1, 0));
        while(!priorityQueue.isEmpty()) {
            Edge tmp = priorityQueue.poll();
            int ev = tmp.vertex;
            if(ch[ev] == 0) {
                answer += tmp.cost;
                ch[ev] = 1;
                for (Edge x : list.get(ev)) {
                    if(ch[x.vertex] == 0) priorityQueue.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v+1];

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

        solution(1);

        System.out.println(answer);

    }
}
