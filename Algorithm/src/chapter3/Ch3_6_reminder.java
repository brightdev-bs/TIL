package chapter3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch3_6_reminder {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        int rt = 0, lt = 0, answer = Integer.MIN_VALUE;
        while(rt != n) {
            if(arr[rt] == 1) rt++;
            else {
                if(list.size() == m) {
                    answer = Math.max(answer, rt - lt - 1);
                    lt = list.get(0);
                    list.remove(0);
                } else {
                    list.add(rt++);
                }
            }
        }

        System.out.println(answer);
    }
}
