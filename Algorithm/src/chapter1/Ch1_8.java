package chapter1;

import java.util.Scanner;


public class Ch1_8 {

    public static String solution(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // replace에는 정규식 못쓰고 replaceAll에는 정규식 쓸 수 있음.
        //System.out.println(s);

        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(solution(s));
    }
}
