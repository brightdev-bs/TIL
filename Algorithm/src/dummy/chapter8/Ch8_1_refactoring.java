package dummy.chapter8;

import java.util.Scanner;

public class Ch8_1_refactoring {

    static int total = 0;
    static String answer = "NO";

    public static void DFS(int[] arr, int L, int sum) {
        if(total - sum == sum) {
            answer = "YES";
            return;
        }

        if(L == arr.length) return;
        else {
            DFS(arr, L+1, sum + arr[L]);
            DFS(arr, L+1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(arr, 0, 0);
        System.out.println(answer);

    }
}
