package baekjoon;

import java.util.Scanner;

public class B1629 {

    static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        System.out.println(pow(a, b));
    }

    static long pow(long base, long exponent) {
        if(base == 1 || exponent == 1)
            return base % c;

        long tmp = pow(base, exponent / 2);

        if(exponent % 2 == 1)
            return (tmp * tmp % c) * base % c;

        return tmp * tmp % c;
    }
}
