package dummy.chapter8;

import java.util.Scanner;

public class Ch8_4 {

    static int n,m;
    static int[] nums;

    public static void DFS(int idx, int count, String answer) {
        if(count == m || idx >= n) {
            System.out.println(answer);
            return;
        } else {
            DFS(idx, count + 1, answer + " " + nums[idx]);
            DFS(idx + 1, count, answer);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        DFS(0, 0, "");
    }
}
