package dummy.chapter8;

import java.util.Scanner;

public class Ch8_6 {
    static int n,m;
    static int[] nums, ch, answer;

    public static void DFS(int L) {
        if(L == m) {
            for(int n : answer) {
                System.out.print(n + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = nums[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n];
        ch = new int[n];
        answer = new int[m];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        DFS(0);
    }
}
