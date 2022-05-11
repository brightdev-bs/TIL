package prime;

import java.util.Scanner;

public class B1978 {

    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n-- > 0) {
            int num = sc.nextInt();
            if(isPrime(num)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
