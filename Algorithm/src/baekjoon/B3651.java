package baekjoon;

import java.util.Scanner;

public class B3651 {

    static int n,k;

    static int solution(int n) {
        int answer = 1;
        for(int i = 1; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        int child = solution(n);
        int parent = solution(k) * solution(n-k);

        System.out.println(child/parent);
    }
}
