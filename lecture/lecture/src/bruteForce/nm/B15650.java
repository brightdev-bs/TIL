package bruteForce.nm;

import java.util.Scanner;

public class B15650 {

    static boolean[] ch = new boolean[9];
    static int[] memory = new int[9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(1,0, n, m);
    }

    public static void solution(int start, int count, int n, int m) {
        if(count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(memory[i] + " ");
            }
            System.out.println();
        }

        for(int i = start; i <= n; i++) {
            ch[i] = true;
            memory[count] = i;
            start = i + 1;
            solution(start, count + 1, n, m);
            ch[i] = false;
        }
    }
}
