package chapter4;

import java.util.HashMap;
import java.util.Scanner;

public class Ch4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String s2 = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(Character c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }


        for(Character c : map.keySet()) {
            if(map.size() != map2.size()) {
                System.out.println("NO");
                return;
            }
            if(map.get(c) != map2.get(c)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }
}
