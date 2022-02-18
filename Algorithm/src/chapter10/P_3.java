package chapter10;

import java.util.Scanner;

public class P_3 {

    static int[] arr, dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        arr = new int[n];
        dy = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        dy[0] = 1;
        for(int i = 1; i < n; i++) {
            int biggest = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dy[j] > biggest) {
                    biggest = dy[j];
                }
            }
            dy[i] = biggest + 1;
        }

        int max = 0;
        for(int a : dy) {
            if(a > max) max = a;
        }

        System.out.println(max);
    }
}
