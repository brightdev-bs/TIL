package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_10_reminder {

    public static int checker(int[] arr, int middle) {
        int count = 1, idx = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - idx >= middle) {
                count++;
                idx = arr[i];
            }
        }
        return count;
    }

    public static int solution(int[] arr, int c) {
        int start = arr[0], end = arr[arr.length-1], answer = Integer.MIN_VALUE;
        while(start <= end) {
            int middle = (start + end) / 2;
            if(checker(arr, middle) >= c) {
                answer = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마굿간의 x좌표
        int c = sc.nextInt(); // 말의 수

        int[] pt = new int[n];
        for(int i = 0; i < n; i++) {
            pt[i] = sc.nextInt();
        }

        Arrays.sort(pt); // 오름차순 정렬;

        System.out.println(solution(pt, c));
    }
}
