package dummy.chapter2;

import java.util.Scanner;

public class Ch2_8 {
    public static int n;
    public static int solution(int num, int[] arr) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(num < arr[i] ) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : arr) {
            System.out.print(solution(x, arr) + 1 + " ");
        }
    }
}
