package divisor;

import java.util.Scanner;

public class B17427RR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            ans += (n / i) * i;
        }

        System.out.println(ans);

    }
}
