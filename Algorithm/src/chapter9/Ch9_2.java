package chapter9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ch9_2 {
    public static int answer = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n+1][3];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });

        int end = arr[1][2];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= 1; j++) {
                if(arr[i][j] >= end) {
                    answer++;
                    end = arr[i][2];
                }
            }
        }

        System.out.println(answer);
    }
}
