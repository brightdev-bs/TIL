package dummy.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_9_reminder2 {

    public static void solution(int[] arr, int start, int end, int m) {
        int answer = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0, count = 1;
            for(int i = 0; i < arr.length; i++) {
                if(sum + arr[i] <= mid) sum += arr[i];
                else {
                    sum = arr[i];
                    count++;
                }
            }
            if(count <= m) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else if(count > m) {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Arrays.stream(arr).sum();

        solution(arr, 0,max, m);
    }
}
