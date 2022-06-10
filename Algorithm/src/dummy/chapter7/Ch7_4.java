package dummy.chapter7;

import java.util.Scanner;

public class Ch7_4 {
    public static int[] memo;

    public static int solution(int n) {
        if(memo[n] != 0) return memo[n];
        if(n == 1 || n == 2) return memo[n] = 1;
        else {
            return memo[n] = solution(n-2) + solution(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new int[n+1];

        for(int i = 1; i <= n; i++)
            System.out.println(solution(i));
    }
}
