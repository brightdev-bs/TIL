package dummy.chapter3;

import java.util.Scanner;

public class Ch3_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int answer = 0;
        int lt = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == m) answer++;
            while(sum > m) {
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }

        System.out.println(answer);
    }
}
