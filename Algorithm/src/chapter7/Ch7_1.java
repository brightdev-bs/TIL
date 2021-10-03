package chapter7;

import java.util.Scanner;

public class Ch7_1 {
    public static void solution(int n) {
        if(n == 0) return;
        else {
            solution(n - 1);
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        solution(n);
    }
}
