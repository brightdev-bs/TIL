package dataStructure;

import java.util.Scanner;

public class Combination_reminder {

    static int[] answer;
    static int n,m;

    public static void solution(int L, int s) {
        if(L == m) {
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for(int i = s; i <= n; i++) {
                answer[L] = i;
                solution(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];

        solution(0,1);

    }
}
