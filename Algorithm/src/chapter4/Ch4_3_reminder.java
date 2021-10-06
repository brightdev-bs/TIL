package chapter4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Ch4_3_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        int lt = 0;
        for(int i = m-1; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
            System.out.print(map.size() + " ");
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }
    }
}
