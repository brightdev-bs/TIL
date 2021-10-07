package chapter5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int idx, prior;
    Person(int i, int p) {
        idx = i;
        prior = p;
    }
}

public class Ch5_8_reminder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            queue.offer(new Person(i, p));
        }

        int cnt = 1;
        while(true) {
            Person p = queue.poll();
            for(Person tmp : queue) {
                if(p.prior < tmp.prior) {
                    queue.offer(p);
                    break;
                }
            }
            if(!queue.contains(p)) {
                if(p.idx == m) {
                    System.out.println(cnt);
                    break;
                }
                else cnt++;
            }
        }
    }
}
