package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class P_2 {

    static int answer = 0;

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end)
                return this.start - o.start;
            else
                return this.end - o.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings);

        int ep = -1;
        for(Meeting m : meetings) {
            if(m.start >= ep) {
                ep = m.end;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
