package prime;

import java.util.Scanner;

public class B1929R {

    static boolean[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new boolean[m + 1];
        ch[0]=ch[1]=true;
        for(int i = 2; i <= m; i++) {
            if(ch[i] == true) {
                continue;
            }

            for(int j = i + i; j <= m; j += i) {
                ch[j] = true;
            }
        }

        for(int i = n; i <= m; i++) {
            if(!ch[i]) System.out.println(i);
        }
    }
}
