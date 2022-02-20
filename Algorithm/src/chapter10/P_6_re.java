package chapter10;

import java.util.Scanner;

public class P_6_re {

    static int[] dy;

    static class Question {
        int score, time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        dy = new int[m + 1];

        Question[] arr = new Question[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr[i] = new Question(s,t);
        }

        for(Question tmp : arr) {
            int cs = tmp.score;
            int ct = tmp.time;
            for(int j  = m; j >= ct; j--) {
                if(cs + dy[j - ct] > dy[j]) dy[j] =  cs + dy[j - ct];
            }
        }
        System.out.println(dy[m]);
    }
}
