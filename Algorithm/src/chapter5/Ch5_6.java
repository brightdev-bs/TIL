package chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch5_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int cnt = 1;
        int answer = 0;
        while(true) {
            if(cnt == k) {
                queue.poll();
                cnt = 1;
            }
            else  {
                queue.offer(queue.poll());
                cnt++;
            }
            if(queue.size() == 1) {
                answer = queue.poll();
                break;
            }
        }

        System.out.println(answer);
    }
}
