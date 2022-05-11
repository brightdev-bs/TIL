package prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1929 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 에라토스테네스의 체
        boolean[] ch = new boolean[m + 1];
        ch[0] = ch[1] = true;
        for(int i = 2; i * i <= m; i++) {
            if (ch[i] == true) {
                continue;
            }

            for (int j = i + i; j <= m; j += i) {
                ch[j] = true;
            }
        }

        for(int i = n; i <= m; i++) {
            if (ch[i] == false) {
                System.out.println(i);
            }
        }
    }
}
