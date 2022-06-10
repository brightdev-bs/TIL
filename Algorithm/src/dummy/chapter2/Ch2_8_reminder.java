package dummy.chapter2;

import java.util.Scanner;


public class Ch2_8_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) cnt++;
            }
            System.out.print(cnt + " ");
        }


    }
}
