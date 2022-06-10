package dummy.chapter1;

import java.util.Scanner;

public class Ch1_9 {

    public static int solution(String s) {
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                answer += s.charAt(i);
            }
        }


        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(solution(s));
    }
}
