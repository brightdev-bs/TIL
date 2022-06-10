package dummy.chapter1;

import java.util.Scanner;

public class Ch1_3_remind {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine() + " ";

        String answer = "";
        String tmp = "";
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                if(answer.length() < tmp.length()) {
                    answer = tmp;
                }
                tmp = "";
            } else {
                tmp += c;
            }
        }
        System.out.println(answer);
    }
}
