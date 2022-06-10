package dummy.chapter2;

import java.util.Scanner;

public class Ch2_10 {
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        board = new int[n+2][n+2];


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(board[nx][ny] >= board[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }

        System.out.println(answer);
    }
}
