package Chapter1;

import java.util.Scanner;

public class Ch1_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        for(char c : s.toCharArray()) {
            if('a' <= c)
                System.out.print((char)(c - 32));
            else
                System.out.print((char)(c + 32));
        }

    }
}
