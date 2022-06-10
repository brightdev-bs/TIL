package dummy.chapter1;

import java.util.Scanner;

public class Ch1_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String lowerCase = s.toLowerCase();
        char[] c = lowerCase.toCharArray();

        int lt = 0, rt = s.length() - 1;

        while(lt < rt) {
            if(c[lt] == c[rt]) {
                lt++; rt--;
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
