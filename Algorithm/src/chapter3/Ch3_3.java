package chapter3;

import java.util.Scanner;

public class Ch3_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i < m; i++) {
            max += arr[i];
        }

        int answer = max;
        for(int i = m; i < n - m; i++) {
            max -= arr[i-m];
            max += arr[i];
            answer = Math.max(answer, max);
        }

        System.out.println(answer);
    }
}
