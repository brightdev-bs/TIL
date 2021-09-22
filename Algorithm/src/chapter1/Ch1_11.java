package chapter1;

import java.util.Scanner;

public class Ch1_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int cnt = 0;
        char prior = s.charAt(0);
        for(char c : s.toCharArray()) {
            if(c == prior) cnt++;
            else {
                if(cnt > 1)
                    System.out.printf("%c%d",prior, cnt);
                    //System.out.print(prior + cnt);
                else
                    System.out.printf("%c", prior);
                cnt = 1;
                prior = c;
            }
        }
        if(cnt > 1)
            System.out.printf("%c%d",prior, cnt);
        else
            System.out.printf("%c", prior);
    }
}
