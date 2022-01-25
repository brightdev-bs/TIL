package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
    static int[][] board;
    static int[] ch;

    static void DFS(int start) {
        ch[start] = 1;
        System.out.print(start + " ");
        for(int i = 0; i < board[0].length; i++) {
            if(board[start][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        ch[start] = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int cp = queue.poll();
                System.out.print(cp + " ");
                for(int j = 0; j < board[0].length; j++) {
                    if(board[cp][j] == 1 && ch[j] == 0) {
                        ch[j] = 1;
                        queue.offer(j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();

        ch = new int[v+1];
        board = new int[v+1][v+1];
        for(int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            board[from][to] = 1;
            board[to][from] = 1;
        }

        DFS(start);
        System.out.println();
        Arrays.fill(ch, 0);
        BFS(start);
    }
}
