package dummy.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_10 {
    public static int[] arr;

    public static int checker(int dis) {
        int prior = arr[0];
        int cnt = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - prior >= dis) {
                cnt++;
                prior = arr[i];
            }
        }

        return cnt;
    }

    public static int solution(int n, int m) {
        int answer = -1;
        int lt = 1;
        int rt = arr[n-1];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(checker(mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마구간
        int m = sc.nextInt(); // 소

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(solution(n,m));

    }
}
