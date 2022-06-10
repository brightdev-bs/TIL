package dummy.chapter2;

import java.util.Scanner;

public class Ch2_1 {

    public static void solution(int[] arr) {
        System.out.print(arr[0] + " ");
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1])
                System.out.print(arr[i] + " ");
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
