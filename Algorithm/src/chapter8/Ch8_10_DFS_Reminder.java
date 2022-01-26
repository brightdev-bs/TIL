package chapter8;

import java.util.Scanner;

// easy
public class Ch8_10_DFS_Reminder {
    static final int SIZE = 7;
    static int[][] board;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static int answer = 0;

    public static void DFS(int x, int y) {
        if(x == SIZE && y == SIZE) answer++;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= SIZE && ny >= 1 && ny <= SIZE && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                DFS(nx, ny);
                board[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[SIZE + 1][SIZE + 1];
        for(int i = 1; i <= SIZE; i++) {
            for(int j = 1; j <= SIZE; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;
        DFS(1,1);
        System.out.println("answer = " + answer);
    }
}
