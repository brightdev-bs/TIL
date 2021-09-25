package chapter2;

import java.util.Arrays;
import java.util.Scanner;

// 세로 열 기준으로 코딩을 했는데 이러면 안됨 -> 1번 2번 학생이 1학년 때 같은반 -> 3학년 때도 같은 반 이렇게 되면 cnt를 2벉하게 됨.
public class Ch2_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int index = 0;
        int max = 0;
        for(int i = 1; i <= n; i++) { // 학생 번호
            int cnt = 0;
            for(int j = 1; j <= n; j++) { // 학년
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt) {
                max = cnt;
                index = i;
            }
        }
        System.out.println(index);
    }
}
