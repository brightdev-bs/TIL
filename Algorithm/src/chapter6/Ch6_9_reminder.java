package chapter6;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ch6_9_reminder {
    public static int[] arr;

    public static int checker(int size) {
        int sum = 0;
        int cnt = 1;
        for(int x : arr) {
            if(sum + x > size) {
                cnt++;
                sum = x;
            } else
                sum += x;
        }
        return cnt;
    }

    public static int solution(int n, int m) {
        int answer = -1;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(checker(mid) <= m) {
                answer = mid;
                rt = mid-1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m =sc.nextInt();

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n,m));
    }
}
