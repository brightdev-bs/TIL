package chapter4;

import java.util.HashMap;
import java.util.Scanner;

public class Ch4_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String s = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }

        int max = Integer.MIN_VALUE;
        char answer =' ';
        for(char x : map.keySet()) {
            if(max < map.get(x)) {
                max = Math.max(max, map.get(x));
                answer = x;
            }
        }

        System.out.println(answer);
    }
}
