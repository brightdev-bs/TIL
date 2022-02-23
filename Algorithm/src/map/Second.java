package map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

// 인프런 - 아나그램
public class Second {

    static HashMap<Character, Integer> map1 = new HashMap<>();
    static HashMap<Character, Integer> map2 = new HashMap<>();

    public static String solution(String s1, String s2) {
        if(s1.length() != s2.length()) return "NO";
        for(Character c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        for(Character c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c,0)+1);
        }

        for(Character c : map2.keySet()) {
            if(map1.get(c) != map2.get(c)) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(solution(s1, s2));
    }
}
