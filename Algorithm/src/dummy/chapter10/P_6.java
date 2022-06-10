package dummy.chapter10;

import java.util.Scanner;

public class P_6 {

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
        int t = sc.nextInt();

        Question[] arr = new Question[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new Question(a, b);
        }

    }
}
