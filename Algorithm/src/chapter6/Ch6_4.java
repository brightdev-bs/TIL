package chapter6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch6_4 {

    public static int[] solution(int[] arr, int size) {
        int[] answer = new int[size];
        for(int x : arr) {
            int pos = -1;
            for(int i = 0; i < answer.length; i++) {
                if(answer[i] == x) pos = i;
            }

            if(pos == -1) {
                for(int i = size - 1; 1 <= i; i--) {
                    answer[i] = answer[i-1];
                }
            } else {
                for(int i = pos; 1 <= i; i--) {
                    answer[i] = answer[i-1];
                }
            }
            answer[0] = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : solution(arr,s)) {
            System.out.print(x + " ");
        }
    }
}
