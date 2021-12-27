package chapter7;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch7_11_reminder2 {
    static int[] ch;
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;

    public static void DFS(int idx) {
        if(idx == n) {
            answer++;
        } else {
            for(int nx : graph.get(idx)) {
                if(ch[nx] == 0) {
                    ch[nx] = 1;
                    DFS(nx);
                    ch[nx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n+1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }


        for(int i=0; i<m; i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        DFS(1);

        System.out.println(answer);
    }
}
