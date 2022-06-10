package dummy.chapter2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch2_9 {
    // 피드백 : colMax, rowMax 합칠 수 있음. for문 4개 아니고 2개로
    public static int solution(int s, int[][] arr) {
        ArrayList<Integer> answers = new ArrayList<>();
        int rowMax = 0;
        for(int i = 0; i < s; i++) {
            int max = 0;
            for(int j = 0; j < s; j++) {
                max += arr[i][j];
            }
            rowMax = Math.max(rowMax, max);
        }
        answers.add(rowMax);

        int colMax = 0;
        for(int i = 0; i < s; i++) {
            int max = 0;
            for(int j = 0; j <s; j++) {
                max += arr[j][i];
            }
            colMax = Math.max(colMax, max);
        }
        answers.add(colMax);

        int leftDia = 0;
        for(int i = 0; i < s; i++) {
            leftDia += arr[i][i];
        }
        answers.add(leftDia);

        int rightDia = 0;
        for(int i = 4; 0 <= i; i--) {
            rightDia += arr[i][i];
        }
        answers.add(rightDia);

        int answer = 0;
        for(int x : answers) {
            if(x > answer ) answer = x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, board));
    }
}
