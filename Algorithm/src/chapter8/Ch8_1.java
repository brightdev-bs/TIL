package chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Ch8_1 {

    static int[] arr, ch;
    static String answer = "NO";

    public static void DFS(int idx) {
        if(check(idx)) {
            answer = "YES";
            return;
        }

        if(idx == arr.length) return;

        for(int i = 0; i < arr.length; i++) {
            if(ch[i] == 0) {
                ch[i] = 1;
                DFS(idx++);
                ch[i] = 0;
            }
        }
    }

    public static boolean check(int end) {
        int first = 0, second = 0;
        for(int i = 0; i < arr.length; i++) {
            if(ch[i] == 0) first += arr[i];
            else second += arr[i];
        }
        return first == second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        ch = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);

        System.out.println(answer);
    }
}
