package dummy.chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch8_13 {
    static int[][] board, check;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int answer = 0, n;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int start, int end) {
        if(check[start][end] == 1) return;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, end));
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Point p = queue.poll();
                for(int j = 0; j < dx.length; j++) {
                    for(int k = 0; k < dx.length; k++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && check[nx][ny] == 0 && board[nx][ny] == 1) {
                            check[nx][ny] = 1;
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }

            }
        }
        answer++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        인풋 입력 받기.
        n = sc.nextInt();
        board = new int[n][n];
        check = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    BFS(i, j);
                }
           }
        }
        System.out.println("answer = " + answer);
    }
}
