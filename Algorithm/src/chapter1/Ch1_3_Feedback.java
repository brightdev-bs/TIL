package chapter1;

import java.util.Scanner;

public class Ch1_3_Feedback {
    public static String solution(String s) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] arr = s.split(" ");
        for(String x : arr) {
            int len = x.length();
            if(len > max) {
                max = len;
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solution(s));
    }
}
