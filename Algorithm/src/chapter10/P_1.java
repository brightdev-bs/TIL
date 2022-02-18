package chapter10;

import java.util.Scanner;

public class P_1 {

    static int answer = 0, n;

    public static void DFS(int floor, int step) {
        if(floor > n) return;
        else if(floor == n) {
            answer++;
        } else {
            DFS(floor + 1, step+1);
            DFS(floor+2, step+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        DFS(0,0);

        System.out.println(answer);
    }
}
