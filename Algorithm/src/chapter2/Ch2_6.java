package chapter2;

import java.util.Scanner;

public class Ch2_6 {

    public static boolean isPrime(int n) {
        if(n==1) return false;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new StringBuilder(sc.next()).reverse().toString();
        }


        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i]);
            if(isPrime(num)) System.out.print(num + " ");
            //if(ch[num] == 0) System.out.print(num + " ");
        }
    }
}
