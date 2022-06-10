package dummy.chapter6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch6_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n-1; i++) {
            if(arr[i+1] < arr[i])
                if(list.size() == 0) list.add(i+1);
                else list.add(i+2);
        }

        for(int x : list) {
            System.out.print(x + " ");
        }
    }
}
