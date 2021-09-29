package chapter5;

import java.util.*;

public class Ch5_8 {
    public static class Person {
        int pr, idx;
        Person(int pr, int idx) {
            this.pr = pr;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int pr = sc.nextInt();
            queue.add(new Person(pr, i));
        }

        int cnt = 1;
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            boolean flag = true;
            for(Person p : queue) {
                if(tmp.pr < p.pr) {
                    queue.offer(tmp);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(tmp.idx == m) {
                    System.out.println(cnt);
                    break;
                }
                else cnt++;
            }
        }
    }
}
