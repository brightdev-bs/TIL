package dataStructure;

import java.util.Scanner;

public class DP01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(); // 물품의 수, 버틸 수 있는 무게
        int[] dy = new int[k + 1];

        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for(int j = k; j >= w; j--) {
                if(dy[j-w] + v > dy[j]) dy[j] = dy[j-w] + v;
            }
        }

        System.out.println(dy[k]);

    }
}
