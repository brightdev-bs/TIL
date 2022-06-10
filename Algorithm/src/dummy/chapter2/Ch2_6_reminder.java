package dummy.chapter2;

import java.util.Scanner;

public class Ch2_6_reminder {
    public static int[] ch;

    public static boolean check(int n) {
        if(n == 1 || n == 0) return false;
        ch = new int[n+1];

        for(int i = 2; i < n; i++) {
            if(ch[i] == 0) {
                for(int j = i; j <= n; j = j + i) ch[j] = 1;
            }
        }

        if(ch[n] == 0) return true;
        else return false;
    }

    public static void solution(int[] arr) {
        for(int a : arr) {
            String s = String.valueOf(a);
            String s2 = new StringBuilder(s).reverse().toString();
            int rev = Integer.parseInt(s2);
            if(check(rev)) System.out.print(rev + " ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }
}
