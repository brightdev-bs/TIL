package algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {

    static int[][] box,ch;
    static int m,n;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); // 가로 칸의 수
        n = sc.nextInt(); // 세로 칸의 수

        box = new int[n][m];
        ch = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int input = sc.nextInt();
                box[i][j] = input;
                if(input == 1) q.add(new Point(i, j));
            }
        }

        BFS();

        int answer = -1;
        if(checkTomato()) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    answer = Math.max(answer, ch[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(answer);
    }

    private static boolean checkTomato() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                    ch[nx][ny] = ch[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}
