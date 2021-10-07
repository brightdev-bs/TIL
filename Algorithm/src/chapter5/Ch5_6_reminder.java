package chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 너무 쉬움
public class Ch5_6_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        while(queue.size() != 1) {
            if(cnt == m) {
                queue.poll();
                cnt = 1;
            } else {
                queue.offer(queue.poll());
                cnt++;
            }
        }

        System.out.println(queue.poll());

    }
}
