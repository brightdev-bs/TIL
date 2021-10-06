package chapter1;

import java.util.Scanner;

public class Ch1_8_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().toLowerCase();
        char[] c = s.toCharArray();
        int lt = 0, rt = s.length()-1;

        while(lt <= rt) {
            if(!Character.isAlphabetic(c[lt])) lt++;
            if(!Character.isAlphabetic(c[rt])) rt--;
            if(Character.isAlphabetic(c[lt]) && Character.isAlphabetic(c[rt])) {
                if(c[lt] != c[rt]) {
                    System.out.println("NO");
                    return;
                }
                rt--; lt++;
            }
        }

        System.out.println("YES");
    }
}
