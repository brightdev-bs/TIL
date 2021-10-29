package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch7_8_reminder {
    public static int[] ch;
    public static int[] move = {1, -1, 5};

    public static int BFS(int n,  int m) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        ch[n] = 1;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                if(x == m) return cnt;
                for(int j = 0; j < move.length; j++) {
                    int dx = x + move[j];
                    if(dx >= 1 && dx <= 10000 && ch[dx] == 0) {
                        queue.offer(dx);
                        ch[dx] = 1;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ch = new int[100001];
        System.out.println(BFS(n,m));
    }
}
