package chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch1_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char c = sc.next().charAt(0);

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) list.add(i);
        }

        for(int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < list.size(); j++) {
                int tmp = Math.abs(i-list.get(j));
                min = Math.min(min, tmp);
            }
            System.out.print(min + " ");
        }
    }
}
