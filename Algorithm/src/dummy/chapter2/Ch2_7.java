package dummy.chapter2;

import java.util.Scanner;

public class Ch2_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int answer = 0;
        int prior = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                answer += ++prior;
            } else {
                prior = 0;
            }
        }
        System.out.println(answer);
    }
}
