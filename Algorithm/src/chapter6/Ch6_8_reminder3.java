package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch6_8_reminder3 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            list.add(input);
        }

        Collections.sort(list);

        search(target);
    }

    public static void search(int target) {
        int start = 0, end = list.size() - 1;
        while(true) {
            int middle = (start + end) / 2;
            if(list.get(middle) == target) {
                System.out.println(middle + 1);
                break;
            } else if(list.get(middle) < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }
}
