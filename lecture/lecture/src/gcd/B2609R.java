package gcd;

import java.util.Scanner;

public class B2609R {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = getGcd(a, b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int getGcd(int a, int b) {
        if(b == 0) return a;
        else return getGcd(b, a % b);
    }
}
