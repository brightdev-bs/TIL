package chapter2;

import java.util.Scanner;

public class Ch2_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] revArr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            revArr[i] = reverse(tmp);
        }

        // 소수 인지 확인해야 함.

    }

    public static int reverse(int n) {
        String s = "";
        while(n > 0) {
            s += n % 10;
            n = n / 10;
        }
        return Integer.valueOf(s);
    }
}
