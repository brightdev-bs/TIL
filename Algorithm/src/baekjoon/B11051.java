package baekjoon;

import java.util.Scanner;

// 이항계수2
public class B11051 {

    static int n,k;
    static int[][] answers = new int[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0) {
                    answers[i][j] = 1;
                } else{
                    answers[i][j] = (answers[i-1][j-1] + answers[i-1][j]) % 10007;
                }
            }
        }

        System.out.println(answers[n][k]);
    }
}
