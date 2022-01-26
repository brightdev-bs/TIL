package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2178 {
    static int[][] board, dis;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int n,m;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        board[x][y] = 0;
        dis[x][y] = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i = 0; i < dx.length; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String input = sc.next();
            char[] inArr = input.toCharArray();
            for(int j = 0; j < m; j++) {
                board[i][j+1] = inArr[j] - '0';
            }
        }

        //DFS(1,1, 1);
        BFS(1,1);
        System.out.println(dis[n][m]);
    }
}
