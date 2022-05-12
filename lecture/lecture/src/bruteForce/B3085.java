package bruteForce;

import java.util.Scanner;

public class B3085 {

    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        board = new char[n][n];
        for(int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j + 1 < n) { // 오른쪽 이동
                    char tmp = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = tmp;
                    int count = check(i, i, j, j + 1);
                    if(ans < count) ans = count;
                    char tmp2 = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = tmp2;
                }

                if(i + 1 < n) {
                    char tmp = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = tmp;
                    int count = check(i,i+1, j, j);
                    if(ans < count) ans = count;
                    char tmp2 = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = tmp2;
                }
            }
        }

        System.out.println(ans);
    }

    public static int check(int start_row, int end_row, int start_col, int end_col) {
        int size = board.length;
        int ans = 1;
        for(int i = start_row; i <= end_row; i++) {
            int count = 1;
            for(int j = 1; j < size; j++) {
                if(board[i][j] == board[i][j-1]) {
                    count += 1;
                } else {
                    count = 1;
                }
                if(ans < count) ans = count;
            }
        }
        for(int i = start_col; i<= end_col; i++) {
            int cnt = 1;
            for(int j = 1; j < size; j++) {
                if(board[j][i] == board[j-1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if(ans < cnt) ans = cnt;
            }
        }
        return ans;
    }
}
