package chapter1;

import java.util.Scanner;

public class Ch1_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int cnt = 0;

        String answer = "";
        String tmp = "";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ' ') {
                answer = tmp.length() < answer.length() ? answer : tmp;
                tmp = "";
            }
            else
                tmp += c;
        }

        answer = tmp.length() < answer.length() ? answer : tmp;

        System.out.println(answer);
    }

}
