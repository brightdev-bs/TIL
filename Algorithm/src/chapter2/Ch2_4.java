package chapter2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
           if(i == 0 || i == 1) arr.add(1);
           else
               arr.add(arr.get(i-1) + arr.get(i-2));
        }

        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
