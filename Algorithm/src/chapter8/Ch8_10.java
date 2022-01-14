package chapter8;

import java.util.Scanner;

public class Ch8_10 {
    static int[][] board;
    static int[] horizontal = {-1, 0, 0, 1}, vertical = {0, -1, 1, 0};
    static int answer = 0;

    public static void DFS(int x, int y) {
        if(x == 7 && y == 7) answer++;
        else {
            for(int i = 0; i < horizontal.length; i++) {
                int nx = x + horizontal[i];
                int ny = y + vertical[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    // horizontal, vertial을 더하는 경우에서 같은 자리로 돌아오는 반복이 생김.
                    // 따라서 이를 체크해주고 나중에 돌아갈 때 체크해제해줘야함.
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[8][8];

        for(int i = 1 ; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        board[1][1] = 1;
        DFS(1,1);
        System.out.println(answer);
    }
}
