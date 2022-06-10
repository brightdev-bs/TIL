package dummy.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_8_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int lt = 0, rt = arr.length-1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(m == arr[mid]) {
                System.out.println(mid+1);
                break;
            }
            if(m < arr[mid]) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }
    }
}
