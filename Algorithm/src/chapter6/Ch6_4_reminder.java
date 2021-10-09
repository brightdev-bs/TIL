package chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch6_4_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.offer(0);
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if(queue.contains(x)) {
                queue.remove(x);
                queue.offer(x);
            } else {
                queue.poll();
                queue.offer(x);
            }
        }


        ArrayList<Integer> list = new ArrayList<>();
        for(int x : queue) {
            list.add(x);
        }
        for(int i = list.size()-1; 0 <= i; i--) {
            System.out.print(list.get(i)+ " ");
        }
    }
}
