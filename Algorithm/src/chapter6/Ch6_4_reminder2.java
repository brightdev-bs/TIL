package chapter6;

import java.util.Scanner;

// 2021-10-23
public class Ch6_4_reminder2 {
    public static int[] ch;

    public static void solution(int[] arr) {
        for(int x : arr) {
            int pos = -1;
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] == x) pos = i;
            }
            if(pos == -1) {
                for(int i = ch.length-1; i >= 1; i--) {
                    ch[i] = ch[i-1];
                }
            } else {
                for (int i = pos; 1 <= i; i--) {
                    ch[i] = ch[i - 1];
                }
            }
            ch[0] = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        ch = new int[s];

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);

        for(int x : ch) {
            System.out.print(x + " ");
        }
    }
}
