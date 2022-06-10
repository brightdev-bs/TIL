package dummy.chapter8;

import java.util.Scanner;

public class Ch8_9 {
    static int n,m;
    static int[] nums, ch,answer;

    public static void DFS(int L, int idx) {
        if(L == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        } else {
            for(int i = idx; i <= n; i++) {
                answer[i] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];

        nums = new int[n+1];
        ch = new int[n+1];

        for(int i = 1; i <= n; i++) {
            nums[i] = i;
        }

        DFS(0,1);
    }
}
