package algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697 {

    static int[] ch = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 수빈 위치
        int k = sc.nextInt(); // 동생 위치

        BFS(n,k);
        System.out.println(ch[k] - 1);
    }

    public static void BFS(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        ch[n] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == k) return;

            int backward = now - 1;
            int forward = now + 1;
            int tele = now * 2;

            if(backward >= 0 && ch[backward] == 0) {
                ch[backward] = ch[now] + 1;
                q.add(backward);
            }

            if(forward <= 100000 && ch[forward] == 0) {
                ch[forward] = ch[now] + 1;
                q.add(forward);
            }

            if(tele <= 100000 && ch[tele] == 0) {
                ch[tele] = ch[now] + 1;
                q.add(tele);
            }
        }
    }
}
