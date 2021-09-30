package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
