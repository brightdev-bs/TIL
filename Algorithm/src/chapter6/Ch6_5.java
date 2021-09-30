package chapter6;

import java.util.Scanner;

public class Ch6_5 {
    public static int[] ch = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(ch[num] == 1) {
                System.out.println("D");
                return;
            } else {
                ch[num] = 1;
            }
        }

        System.out.println("U");
    }
}
