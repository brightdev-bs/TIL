package chapter8;

import java.util.*;

public class Ch8_2 {
    static int c,n, answer = -1;
    static int[] weight, ch;

    public static void DFS(int L, int sum) {
        if(L == n) {
            if(sum <= c && answer < sum) answer = sum;
        } else {
            if(ch[L] == 0) {
                DFS(L+1, sum + weight[L]);
                DFS(L+1, sum);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        weight = new int[n];
        ch = new int[n];
        for(int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        DFS(0, 0);

        System.out.println(answer);
    }
}