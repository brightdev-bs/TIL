package dummy.chapter2;

import java.util.Scanner;

public class Ch2_11_reminder {
    public static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];
        ch = new int[n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(i != j && arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt) {
                answer = i;
                max = cnt;
            }
        }

        System.out.println(answer);
    }
}
