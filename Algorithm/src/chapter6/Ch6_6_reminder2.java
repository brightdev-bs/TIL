package chapter6;

import java.util.Arrays;
import java.util.Scanner;

// 다시 그냥 외워
public class Ch6_6_reminder2 {

    public static void solution(int[] arr) {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i = 0; i < arr.length; i++) {
            if(tmp[i] != arr[i]) System.out.print(i+1 + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }
}
