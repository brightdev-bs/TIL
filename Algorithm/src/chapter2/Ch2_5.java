package chapter2;

import java.util.Scanner;

public class Ch2_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1];
        int answer = 0;

        for(int i = 2; i <= n; i++) {
            if(arr[i] == 0) {
                answer++;
                for(int j = i; j <= n; j=j+i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }
}
