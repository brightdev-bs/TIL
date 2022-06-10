package dummy.chapter9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P_5_reminder {

    static ArrayList<ArrayList<Edge>> list;;
    static int[] dis;

    static class Edge {
        int v, c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int cv = tmp.v;
            int cc = tmp.c;
            if(cc > dis[cv]) continue;
            for(Edge nx : list.get(cv)) {
                if(dis[nx.v] > nx.c + cc) {
                    dis[nx.v] = nx.c + cc;
                    pq.offer(new Edge(nx.v, nx.c + cc));
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        dis = new int[n+1];
        for(int i = 0; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b, c));
        }


    }
}
