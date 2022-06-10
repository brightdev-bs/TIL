package dummy.chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch5_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            queue.offer(c);
        }

        for(char c : p.toCharArray()) {
            if(queue.size() == 0) {
                System.out.println("YES");
                return;
            }
            else if(queue.peek() == c) queue.poll();
        }

        System.out.println("NO");
    }
}
