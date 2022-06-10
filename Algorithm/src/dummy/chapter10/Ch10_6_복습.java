package dummy.chapter10;

import java.util.Scanner;

public class Ch10_6_복습 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dy = new int[m+1];

        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            for(int j = m; t <= m; j--) {
                dy[j] = Math.max(dy[j], dy[j-t] + s);
            }
        }

        System.out.println(dy[m]);
    }
}
