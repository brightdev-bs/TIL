package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Way implements Comparable<Way> {
    int vex, cost;
    Way(int v, int c) {
        vex = v;
        cost = c;
    }

    @Override
    public int compareTo(Way o) {
        return this.cost - o.cost;
    }
}

public class Ch9_5 {
    public static int n,m;
    public static ArrayList<ArrayList<Way>> graph;
    public static int[] dis;

    public static void solution(int v) {
        PriorityQueue<Way> pQ = new PriorityQueue<>();
        pQ.offer(new Way(v, 0));
        dis[v] = 0;
        while(!pQ.isEmpty()) {
            Way tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            for(Way ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Way(ob.vex, nowCost + ob.cost));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dis = new int[m+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<ArrayList<Way>>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Way>());
        }

        for(int i = 0; i < m; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int val = sc.nextInt();
            graph.get(c1).add(new Way(c2, val));
        }

        solution(1);
        for(int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
