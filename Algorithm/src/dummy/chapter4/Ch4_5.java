package dummy.chapter4;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Ch4_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            int a = arr[i];
            for(int j = i+1; j < n; j++) {
                int b = arr[j];
                for(int s = j+1; s < n; s++) {
                    int c = arr[s];
                    int sum = a + b + c;
                    tree.add(sum);
                }
            }
        }

        int index = 1;
        for(int x : tree) {
            if(index == k) {
                System.out.print(x + " ");
                return;
            }
            index++;
        }

        System.out.print("-1");
    }
}
