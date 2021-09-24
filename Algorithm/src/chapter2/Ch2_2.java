package chapter2;

import java.util.Scanner;

public class Ch2_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
