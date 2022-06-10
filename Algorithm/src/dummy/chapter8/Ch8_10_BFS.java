package dummy.chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch8_10_BFS {
    static int[][] board = new int[8][8], ch = new int[8][8];
    static int[] dx = {-1,0,0,1}, dy = {0, -1, 1, 0};
    static int answer = -1;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1,1));
        board[1][1] = 1;
        int L = -1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for(int i = 0; i < len; i++) {
                Point p = queue.poll();
                if(p.x == 7 && p.y == 7) {
                    answer = L;
                    return;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        ch[nx][ny] = 1;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS();
        System.out.println(answer);
    }
}
