package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ch7_10 {
    public int[][] arr;
    public int answer = 0;
    public int[] ch;

    public void DFS(int idx, int destination) {
        if(idx == destination) {
            answer++;
            String s = "";
            for(int i = 1; i <= destination; i++) {
                if(ch[i] == 1) s += i;
            }
            System.out.println(s);
        }
        else {
            for(int i = 1; i <= destination; i++) {
                if(arr[idx][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i, destination);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ch7_10 main = new Ch7_10();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        main.arr = new int[n+1][n+1];
        main.ch = new int[n+1];
        main.ch[1] = 1;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            main.arr[a][b] = 1;
        }

        main.DFS(1, n);

        System.out.println(main.answer);
    }
}
