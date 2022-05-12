package bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class B2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 9;
        int[] dwarfs = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            dwarfs[i] = sc.nextInt();
            sum += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(sum - dwarfs[i] - dwarfs[j] == 100) {
                    for(int k = 0; k < n; k++) {
                        if( i == k || j == k) continue;
                        System.out.println(dwarfs[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
