package dummy.chapter10;

import java.util.Scanner;

public class Ch10_5_DFS {
    public static int[] coinType;
    public static int n,m;
    public static int answer = Integer.MAX_VALUE;

    public static void solution(int l, int sum) {
        if(sum > m) return;
        if(sum == m) {
            answer = Math.min(answer, l);
        } else {
            for(int i = 0; i < coinType.length; i++) {
                solution(l+1, sum + coinType[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n  = sc.nextInt();
        coinType = new int[n];

        for(int i = 0; i < n; i++) {
            coinType[i] = sc.nextInt();
        }

        m = sc.nextInt();

        solution(0, 0);

        System.out.println(answer);
    }
}
