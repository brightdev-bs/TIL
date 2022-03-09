package baekjoon;

import java.util.Scanner;

public class B11401 {

    public static int bino_coef(int n, int k) {
        if(n == k || k == 0) return 1;
        return bino_coef(n - 1, k) + bino_coef(n - 1, k - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), K = sc.nextInt();


    }
}
