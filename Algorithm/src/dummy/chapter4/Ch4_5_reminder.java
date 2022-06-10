package dummy.chapter4;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Ch4_5_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        int sum = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    sum += arr[i] + arr[j] + arr[k];
                    set.add(sum);
                    sum = 0;
                }
            }
        }

        int idx = 1, answer = -1;
        for(int x : set) {
            if(idx == m)
                answer = x;
            idx++;
        }
        System.out.println(answer);
    }
}
