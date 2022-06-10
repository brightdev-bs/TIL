package dummy.chapter3;

import java.util.Scanner;

public class Ch3_4_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int sum = 0, lt = 0, rt = 0, cnt = 0;
        while(rt != n) {
            if(sum == m) cnt++;
            if(m < sum) {
                sum -= arr[lt++];
            }else {
                sum += arr[rt++];
            }
        }
        if(sum == m) cnt++;

        System.out.println(cnt);
    }
}
