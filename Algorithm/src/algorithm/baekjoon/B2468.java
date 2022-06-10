package algorithm.baekjoon;

import java.util.Scanner;

public class B2468 {

    static int[][] area;
    static boolean[][] ch;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int n, answer = Integer.MIN_VALUE, maxHeight = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        area = new int[n][n];

        // 지역값 입력 받기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                area[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        // 높이는 1 ~ 100 범위이지만,
        // 1부터 시작하는 경우에 아무 지역도 물에 잠기지 않을 수 있다는 조건을 만족하지 못한다.
        for(int h = 0; h <= maxHeight; h++) {
            ch = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!ch[i][j] && area[i][j] > h) {
                        DFS(i, j, h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    private static void DFS(int x, int y, int h) {
        ch[x][y] = true;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!ch[nx][ny] && area[nx][ny] > h) {
                    DFS(nx, ny, h);
                }
            }
        }
    }
}
