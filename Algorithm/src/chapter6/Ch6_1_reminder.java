package chapter6;

import java.util.Scanner;

public class Ch6_1_reminder {
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[min] > arr[j]) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        for(int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);

    }
}
