package chapter1;

import java.util.Scanner;

public class Ch1_12 {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        for(int k = 0; k < n; k++) {
            String binary = "";
            for(int i = 0; i < 7; i++) {
                if(s.charAt(i + k * 7) == '#') binary += "1";
                else binary += "0";
            }

            int num = 0;
            for(int i = 6 ; 0 <= i; i--) {
                if(binary.charAt(i) == '1')
                    num += Math.pow(2, binary.length() - i - 1);
            }

            System.out.print((char) num);
        }
    }
}
