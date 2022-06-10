package dummy.chapter8;

import java.util.*;

public class Ch8_3 {
    static int answer = 0, n, time_limit;
    static Problem[] problems;

    static class Problem {
        int score, time;
        Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    public static void DFS(int L, int score, int time) {
        if(time > time_limit) return;
        if(L == n) {
            answer = Math.max(answer, score);
        } else {
            DFS(L + 1, score + problems[L].score, time + problems[L].time);
            DFS(L+1, score, time);
        }
    }


    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        time_limit = sc.nextInt();

        problems = new Problem[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            problems[i] = new Problem(s,t);
        }

        DFS(0, 0, 0);

        System.out.println(answer);
    }
}
