package baekjoon;

import java.util.Scanner;

public class B10830 {

    static int n;
    static long b;
    static final int DIV = 1000;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 행렬 크기
        b = sc.nextLong(); // 제곱

        // 행렬 수 입력받기
        matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt() % DIV;
            }
        }

        int[][] answer = solution(matrix,b);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] arr, int[][] arr2) {
        // 매개변수로 넘어 온 배열에 영향을 주지 않기 위해 새로운 배열 선언
        int[][] tmp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int num = 0;
                for(int k = 0; k < n; k++) {
                    num += arr[i][k] * arr2[k][j];
                    num %= DIV;
                }
                tmp[i][j] = num;
            }
        }

        return tmp;
    }

    public static int[][] solution(int[][] arr, long exp) {
        // 지수가 1이면 그냥
        if(exp == 1L) return arr;

        // 분할 정복
        int[][] tmp = solution(arr, exp / 2);

        tmp = pow(tmp, tmp);

        // 홀수이면 처음 입력 받은 매트릭스를 곱해준다.
        if(exp % 2 == 1L) {
            tmp = pow(tmp, matrix);
        }

        return tmp;
    }
}
