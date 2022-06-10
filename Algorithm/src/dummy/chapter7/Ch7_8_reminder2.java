package dummy.chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch7_8_reminder2 {
    static int[] move = {1, -1, 5};
    static int[] ch;

    public static int BFS(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        ch = new int[10001];
        queue.add(s);
        ch[s] = 1;
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                for(int j = 0; j < move.length; j++) {
                    int nx = x + move[j];
                    if(nx == e) return L+1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.add(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }
}
