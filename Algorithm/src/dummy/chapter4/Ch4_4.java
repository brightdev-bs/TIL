package dummy.chapter4;

import java.util.HashMap;
import java.util.Scanner;

public class Ch4_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c,0) + 1);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length() - 1; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int answer = 0;
        int lt = 0;
        for(int rt = t.length() - 1; rt < s.length(); rt++) {
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);
            if(map.equals(map2)) answer++;
            map.put(s.charAt(lt), map.get(s.charAt(lt))-1);
            if(map.get(s.charAt(lt))== 0) map.remove(s.charAt(lt));
            lt++;
        }
        System.out.println(answer);
    }
}
