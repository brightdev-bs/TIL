package divisor;

import java.util.Arrays;
import java.util.Scanner;

public class B1037R {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = arr[0] * arr[n-1];
        System.out.println(answer);

    }
}
