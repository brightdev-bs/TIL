package chapter2;

import java.util.Scanner;

public class Ch2_12_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        int answer = 0;
        for(int mentee = 1; mentee <= n; mentee++) {
            for(int mentor = 1; mentor <= n; mentor++) {
                int cnt = 0;
                for(int i = 1; i <= m; i++) {
                    int teeGrade = 0, torGrade = 0;
                    for(int j = 1; j <= n; j++) {
                        if(arr[i][j] == mentee) teeGrade = j;
                        if(arr[i][j] == mentor) torGrade = j;
                    }

                    if(torGrade < teeGrade) { // 멘토가 1등 멘티가 2등
                        cnt++;
                    }
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
