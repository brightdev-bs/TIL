package algorithm.baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2644 {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] ch;
    static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 전체 사람 수

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();

        int m = sc.nextInt(); // 관계의 개수

        ch = new int[n+1];

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt(); // 부모
            int b = sc.nextInt(); // 자식
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        BFS(p1, p2);
        System.out.println(answer);
    }

    public static void BFS(int p1, int p2) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(p1);
        ch[p1] = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {

                int tmp = q.poll();

                if(tmp == p2) {
                    answer = ch[tmp];
                    return;
                }

                for(int p : arr.get(tmp)) {
                    if(ch[p] == 0) {
                        ch[p] = ch[tmp]+1;
                        q.add(p);
                    }
                }
            }
        }
    }
}
