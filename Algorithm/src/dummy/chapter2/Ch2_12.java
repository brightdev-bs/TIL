package dummy.chapter2;

import java.util.Scanner;

public class Ch2_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 반 학생 수 : 4
        int m = sc.nextInt(); // 테스트 횟수 : 3

        int[][] scores = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int cnt = 0;
                int pi = 0, pj = 0;
                for(int k = 1; k <= m; k++) {
                    for(int s = 1; s <= n; s++) {
                        if(scores[k][s] == i)
                            pi = s;
                        if(scores[k][s] == j)
                            pj = s;
                    }
                    if(pi > pj) cnt++;
                }
                if(cnt == m)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
