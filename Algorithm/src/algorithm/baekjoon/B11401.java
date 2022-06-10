package algorithm.baekjoon;

import java.util.Scanner;

public class B11401 {

    static final long p= 1000000007;
    static int n,k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        long child = factorial(n);

        long parent = (factorial(k) * factorial(n - k)) % p;
        System.out.println(child * solution(parent, p-2) % p);
    }


    public static long factorial(long num) {
        long result = 1;
        while(num > 1) {
            result = (result * num) % p;
            num--;
        }

        return result;
    }

    public static long solution(long base, long exponent) {
        if(base == 1 || exponent == 1) return base % p;

        long tmp = solution(base, exponent / 2);

        if(exponent % 2 == 1)
            return (tmp * tmp % p) * base % p;

        else
            return tmp * tmp % p;
    }
}
