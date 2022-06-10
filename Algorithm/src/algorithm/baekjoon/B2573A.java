package algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 필요한 기능
// 1. 빙하를 녹이는 메소드
// 2. 빙산의 개수를 확인하는 코드
public class B2573A {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    static int row, col;
    static Queue<Iceberg> q = new LinkedList<>();

    static class Iceberg {
        int r, c;

        public Iceberg(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        map = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        int answer = 0;
        while((cnt = countIceberg()) < 2) {
            if(cnt == 0) {
                System.out.println(0);
                return;
            }
            meltIceberg();
            answer++;
        }

        System.out.println(answer);
    }

    public static void meltIceberg() {
        visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] > 0) {
                    q.offer(new Iceberg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            Iceberg cur = q.poll();

            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;

                if(map[nr][nc] <= 0 && !visited[nr][nc]) {
                    cnt++;
                }
            }

            map[cur.r][cur.c] -= cnt;
        }
    }

    public static int countIceberg() {
        visited = new boolean[row][col];

        int cnt = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void DFS(int r, int c) {
        visited[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= row || nc >= col) continue;

            if(map[nr][nc] > 0 && !visited[nr][nc]) {
                DFS(nr, nc);
            }
        }
    }
}
