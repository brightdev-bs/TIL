package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch7_12_reminder {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void BFS(int idx) {

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
