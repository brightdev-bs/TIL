package bruteForce.nm;

import java.util.Scanner;

public class B15651 {

    static boolean[] c = new boolean[10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solution(0, n, m));
    }

    public static StringBuilder solution(int index, int n, int m) {
        if(index == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(a[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            c[i] = true;
            a[index] = i;
            ans.append(solution(index + 1, n, m));
            c[i] = false;
        }

        return ans;
    }

}
