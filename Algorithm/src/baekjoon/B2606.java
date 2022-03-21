package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B2606 {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 컴퓨터 수
        int m = sc.nextInt(); // 연결 쌍
        ch = new int[n+1];

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int idx) {
        ch[idx] = 1;
        for(int n : graph.get(idx)) {
            if(ch[n] == 0) {
                answer++;
                DFS(n);
            }
        }
    }
}
