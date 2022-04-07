package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {

    static int[] dis = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt(); // F층까지 있음
        int S = sc.nextInt(); // 강호의 위치
        int G = sc.nextInt(); // 스타 링크의 위치
        int U = sc.nextInt(); // 위로 가는 버튼
        int D = sc.nextInt(); // 아래로 가는 버튼

        BFS(F, S, G, U, D);

        int answer = dis[G] - 1;
        if(answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }

    public static void BFS(int f, int s, int g, int u, int d) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dis[s] = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                if(s == g) return;
                int nu = cur + u;
                int nd = cur - d;

                if(nu <= f && dis[nu] == 0) {
                    q.add(nu);
                    dis[nu] = dis[cur] + 1;
                }

                if(nd >= 1 && dis[nd] == 0) {
                    q.add(nd);
                    dis[nd] = dis[cur] + 1;
                }
            }
        }
    }

}
