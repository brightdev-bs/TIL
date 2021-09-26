package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ch3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

        ArrayList<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(arr[p1] == arr2[p2]) {
                list.add(arr[p1]);
                p1++; p2++;
            }
            else if(arr[p1] < arr2[p2]) p1++;
            else p2++;
        }

        for(int x : list) {
            System.out.print(x + " ");
        }
    }
}
