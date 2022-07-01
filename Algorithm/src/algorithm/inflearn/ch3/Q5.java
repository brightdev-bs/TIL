package algorithm.inflearn.ch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> list = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n - 2; i++) {
            for(int j = i+1; j < n - 1; j++) {
                for(int s = j+1; s < n; s++) {
                    list.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }

        int cnt = 1;
        for (Integer integer : list) {
            if(cnt == k) {
                System.out.println(integer);
                break;
            }
            else cnt++;
        }
        System.out.println(-1);
    }
}
