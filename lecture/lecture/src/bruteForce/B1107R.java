package bruteForce;

import java.util.Scanner;

public class B1107R {

    static boolean[] broken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 이동하려는 채널
        int m = sc.nextInt(); // 고장난 버튼의 개수

        broken = new boolean[10];
        for(int i = 0; i < m; i++) {
            broken[sc.nextInt()] = true;
        }

        int ans = n - 100;
        if(ans < 0) {
            ans = -ans;
        }

        for(int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = possible(c);
            if(len > 0) {
                int press = c - n;
                if(press < 0) {
                    press = -press;
                }
                if(ans > len + press) {
                    ans = len + press;
                }
            }
        }
        System.out.println(ans);
    }

    public static int possible(int c) {
        while(c == 0) {
            if(broken[0]) return 0;
            else return 1;
        }
        int len = 0;
        while(c > 0) {
            if(broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }
}
