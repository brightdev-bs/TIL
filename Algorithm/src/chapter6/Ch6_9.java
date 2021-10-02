package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_9 {
    public static int[] arr;
    public static int n,m;

    public static int getSize(int size) {
        int sum = 0, cnt = 1;
        for(int x : arr) {
            if(sum + x > size) {
                cnt++;
                sum = x;
            } else
                sum += x;
        }
        return cnt;
    }

    public static int solution() {
        int answer = -1;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(getSize(mid) <= m) {
                rt = mid - 1;
                answer = mid;
            } else
                lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution());
    }
}
