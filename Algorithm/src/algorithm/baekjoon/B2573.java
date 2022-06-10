package algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2573 {

    static int[][] ice;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    static int row,col;

    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        ice = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ice[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        int cnt = 0;
        while((cnt = numberOfIceberg()) < 2) {
            if(cnt == 0) {
                ans = 0;
                break;
            }

            BFS();
            ans++;
        }

        System.out.println(ans);
    }

    private static int numberOfIceberg() {
        visited = new boolean[row][col];

        int cnt = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(ice[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        return cnt;
    }

    // 빙산 구역 갯수 확인
    public static void DFS(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
            }

            if (ice[nr][nc] != 0 && !visited[nr][nc]) {
                DFS(nr, nc);
            }
        }
    }

    // 필요한 기능
    // 1. 시간이 지난 후 빙산의 크기 계산
    // 2. 빙산이 두 덩어리로 나누어졌는지 확인하는 코드

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();

        boolean[][] ch = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(ice[i][j] > 0) {
                    q.offer(new Point(i, j));
                    ch[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            int cnt = 0;
            for(int i = 0; i < dr.length; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                    continue;
                }

                if (ice[nr][nc] != 0 && !ch[nr][nc]) {
                    cnt++;
                }
            }

            ice[p.r][p.c] -= cnt;
        }
    }
}
