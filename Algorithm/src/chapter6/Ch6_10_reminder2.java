package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_10_reminder2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(solution(arr, m));

    }

    public static int solution(int[] arr, int m) {
        int lt = arr[0], rt = arr[arr.length-1];
        int answer = 0;
        while(lt <= rt) {
            int middle = (lt + rt) / 2;
            if(count(arr, middle, m)) {
                lt = middle + 1;
                answer = middle;
            }
            else
                rt = middle - 1;
        }

        return answer;
    }

    public static boolean count(int[] arr, int distance, int m) {
        int count = 1;
        int ep = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= distance) {
                count++;
                ep = arr[i];
            }
            if(count == m) return true;
        }
        return false;
    }
}
