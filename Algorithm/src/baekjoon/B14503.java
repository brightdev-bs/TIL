package baekjoon;

import java.util.Scanner;

public class B14503 {

    static int[][] map;
    static int[] dr = {0,1,0,-1}, dc = {1, 0, -1, 0};
    static int n,m, cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        // 0 : 북, 1 : 동, 2 : 남, 3 : 서
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(r, c, d);

        System.out.println(cnt);
    }

    // 빈 칸은 0, 벽은 1
    public static void DFS(int r, int c, int d) {

        // 현재 위치 청소
        if(map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }

        // 왼쪽 방향 돌면서 탐색
        boolean flag = false;
        int originDirection = d;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            int nd = (d + 3) % 4;

            if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
                if(map[nr][nc] == 0) {
                    DFS(nr,nc, nd);
                    flag = true;
                    break;
                }
            }

            d = (d + 3) % 4;
        }

        // 네 방향 모두 청소가 되어 있는 경우
        if(!flag) {
            int nd = (originDirection + 2) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
                if(map[nr][nc] != 1) {
                    DFS(nr,nc,originDirection); // 바라보는 방향 유지한 채 후진.
                }
            }
        }
    }
}
