package baekjoon;

import java.util.Scanner;

public class B2580 {
    public static final int SIZE = 9;
    public static int[][] board = new int[9][9];

    public static void solution() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(board[i][j] == 0) {

                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                board[i][j] = sc.nextInt();
            }
        }


    }
}
