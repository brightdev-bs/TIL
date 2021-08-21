package com.mango;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 8월 21일 복습.
 */

public class Main{
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    
    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        ch[v] = 1;
        int len = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int tmp = q.poll();
                for(int cur : graph.get(tmp)) {
                    if(ch[cur] == 0) {
                        ch[cur] = 1;
                        q.add(cur);
                        dis[cur] = len;
                    }
                }
            }
            len++;
        }
    }

    public static void main(String args[]) {
        Main T = new Main();
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
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}