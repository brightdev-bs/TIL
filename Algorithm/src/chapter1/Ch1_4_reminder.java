package chapter1;

import java.util.Scanner;

public class Ch1_4_reminder {

    public static void solution(String[] arr) {
        for(String s : arr) {
            int lt = 0, rt = s.length()-1;
            char[] c = s.toCharArray();
            while(lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++; rt--;
            }

            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] sArr = new String[n];

        for(int i = 0; i < n; i++) {
            sArr[i] = sc.next();
        }

        solution(sArr);
    }
}
