package baekjoon;

import java.util.Scanner;

public class B10830 {

    static int n,b;

    public static void solution(int[][] matrix) {
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        b = sc.nextInt();

        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int input = sc.nextInt();
                matrix[i][j] = input;
            }
        }

        // 행렬 n에 대한 b의 제곱 구하기.

    }
}
