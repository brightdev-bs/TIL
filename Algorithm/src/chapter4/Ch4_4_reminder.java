package chapter4;

import java.util.HashMap;
import java.util.Scanner;

// HashMap 두 개가 같은지 비교할 때는 equlas를 사용할 수 있음.
public class Ch4_4_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String target = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        HashMap<Character, Integer> ansMap = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < target.length()-1; i++) {
            ansMap.put(arr[i], ansMap.getOrDefault(arr[i],0)+1);
        }

        int answer = 0, cnt = 0, lt = 0;
        for(int i = target.length()-1; i < arr.length; i++) {
            ansMap.put(arr[i], ansMap.getOrDefault(arr[i],0)+1);
            if(ansMap.equals(map)) answer++;
            ansMap.put(arr[lt], ansMap.get(arr[lt]) - 1);
            if(ansMap.get(arr[lt]) == 0) ansMap.remove(arr[lt]);
            lt++;
        }

        System.out.println(answer);
    }
}
