package chapter1;

import java.util.Scanner;

public class Ch1_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String ups = s.toUpperCase();

        char c = sc.next().charAt(0);

        int cnt = 0;

        for(char tmp : ups.toCharArray()) {
            if(tmp == c || c - ('a' - 'A') == tmp) cnt++;
        }

        System.out.println(cnt);
    }
}
