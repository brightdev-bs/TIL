package dummy.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch3_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n + n2; i++) {
            if(i < n) {
                list.add(arr[i]);
            } else
                list.add(arr2[i - n]);
        }

        Collections.sort(list);

        for(int x : list)
            System.out.print(x + " ");
    }
}
