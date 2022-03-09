package dataStructure;

import java.util.Scanner;

public class Permutation {

    static int n,m;
    static int[] answer;

    public static void solution(int L) {
        if(L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                answer[L] = i;
                solution(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt(); // n : 구슬, m : 뽑는 개수
        answer = new int[m];

        solution(0);
    }
}
