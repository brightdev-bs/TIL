package algorithm.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2667 {
    public static int[][] map;
    public static int[] dx = { -1, 0, 0, 1 };
    public static int[] dy= { 0, -1, 1, 0 };

    public static ArrayList<Integer> answers = new ArrayList<>();
    public static int answer = 0;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        // 맵 초기화
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <n; j++) {
                if(map[i][j] == 1) {
                    DFS(i, j);
                    answers.add(answer);
                    answer = 0;
                }
            }
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        for(int x : answers) {
            System.out.println(x);
        }
    }

    public static void DFS(int x, int y) {
        map[x][y] = 0;
        answer++;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 1)
                DFS(nx, ny);
        }
    }
}
