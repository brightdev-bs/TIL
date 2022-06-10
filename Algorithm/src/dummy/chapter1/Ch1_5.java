package dummy.chapter1;

import java.util.Scanner;

// perfect
public class Ch1_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        char[] c = s.toCharArray();
        int lt = 0, rt = c.length-1;

        while(lt < rt) {

            if(!Character.isAlphabetic(c[lt])) lt++;
            else if(!Character.isAlphabetic(c[rt])) rt--;

            else {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
        }

        System.out.println(c);
    }
}
