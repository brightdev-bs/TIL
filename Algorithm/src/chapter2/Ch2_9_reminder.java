package chapter2;

import java.util.Scanner;

public class Ch2_9_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        // 가로 합
        for(int i = 0; i < n; i++) {
            int col = 0;
            int row = 0;
            for(int j = 0; j < n; j++) {
                row += arr[i][j];
                col += arr[j][i];
            }
            max = Math.max(max, row);
            max = Math.max(max, col);
        }

        int dia1 = 0;
        for(int i = 0; i < n; i++) {
            dia1 +=  arr[i][i];
        }
        max = Math.max(dia1, max);

        int dia2 = 0;
        for(int i = n-1; 0 <= i; i--) {
            dia2 += arr[i][i];
        }
        max = Math.max(dia2, max);

        System.out.println(max);
    }
}
