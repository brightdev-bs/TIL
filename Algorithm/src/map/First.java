package map;

import java.util.*;

// 인프런 - 학급 회장
public class First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String vote = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : vote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set set = map.entrySet();
        Iterator it = set.iterator();
        int max = Integer.MIN_VALUE;
        Character answer = null;
        while(it.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry) it.next();
            if(entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }

        System.out.println(answer);


    }
}
