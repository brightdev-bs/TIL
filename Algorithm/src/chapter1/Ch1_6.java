package chapter1;

import java.util.Scanner;

public class Ch1_6 {
    public static int[] ch = new int[26];

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String answer = "";

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if(ch[index] == 0) {
                ch[index] = 1;
                answer += c;
            }
        }

        System.out.println(answer);
    }
}
