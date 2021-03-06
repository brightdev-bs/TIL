package com.mango.ch7;

import java.util.ArrayList;

import java.util.Scanner;


class Main{
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int x) {
        if(x == n) answer++;
        else {
            for(int tmp : graph.get(x)) {
                ch[tmp] = 1;
                DFS(tmp);
                ch[tmp] = 0;
            }
        }
    }

    public static void main(String args[]) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}