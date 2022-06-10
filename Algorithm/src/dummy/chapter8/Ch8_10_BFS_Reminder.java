package dummy.chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch8_10_BFS_Reminder {
    static final int SIZE = 7;
    static int[][] board, dis;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        board[x][y] = 1;
        while(!queue.isEmpty()) {
        Point p = queue.poll();
            for(int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 1 && nx <= SIZE && ny >= 1 && ny <= SIZE && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[SIZE + 1][SIZE + 1];
        dis = new int[SIZE + 1][SIZE + 1];
        for(int i = 1; i <= SIZE; i++) {
            for(int j = 1; j <= SIZE; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        BFS(1,1);
        System.out.println("answer = " + dis[SIZE][SIZE]);
    }
}
