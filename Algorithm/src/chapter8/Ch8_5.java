package chapter8;

import java.util.Scanner;

// 그리디 알고리즘은 최소개수를 찾을 수 없음 -> dp로 풀어야함.
public class Ch8_5 {
    static int[] coins, check;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        m = sc.nextInt();
        check = new int[m + 1];

        for(int coin : coins) {
            for(int i = coin; i <= m; i++) {
                check[i] = check[i - coin] + 1;
            }
        }

//        for (int i = 0; i < n; i++) {
//            update(coins[i]);
//            for(int x : check) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
//        }

        System.out.println(check[m]);
    }

}