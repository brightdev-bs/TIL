package dataStructure;

import java.util.Scanner;

public class Combination {

    static int[] combi;
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];

        combination(0, 1);
    }

    public static void combination(int L, int s) {
        if(L == m) {
            for (int num : combi) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else{
            for(int i = s; i <= n; i++) {
                combi[L] = i;
                combination(L+1, i+1);
            }
        }
    }
}
