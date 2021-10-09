package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ch6_6_reminder {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) System.out.print(i+1 + " ");
        }


    }
}
