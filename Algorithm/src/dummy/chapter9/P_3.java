package dummy.chapter9;

import java.util.*;

public class P_3 {

    static int answer = 0;

    static class Friend implements Comparable<Friend> {
        int time;
        char state;

        public Friend(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Friend o) {
            if(this.time == o.time)
                return this.state - o.state;
            else
                return this.time - o.time;
        }
    }

    public static void solution(List<Friend> list) {
        int count = 0;
        for(Friend f : list) {
            if(f.state == 's') {
                count++;
                answer = Math.max(answer, count);
            }
            else
                count--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Friend> friends = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int l = sc.nextInt();
            friends.add(new Friend(c,'s'));
            friends.add(new Friend(l,'e'));
        }

        Collections.sort(friends);

        solution(friends);

        System.out.println(answer);
    }
}
