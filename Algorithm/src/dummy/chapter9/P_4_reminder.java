package dummy.chapter9;

import java.util.*;

public class P_4_reminder {

    static class Lecture implements Comparable<Lecture> {
        int money, time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    public static int solution(List<Lecture> list) {
        Collections.sort(list);
        int max = list.get(0).time;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 큰 수 우선권.
        int j = 0;
        int answer = 0;
        for(int  i = max; i >= 1; i--) {

            for( ; j < list.size(); j++) {
                if(list.get(j).time < i) break;
                pQ.add(list.get(j).money);
            }

            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Lecture> lectures = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();
            lectures.add(new Lecture(m,t));
        }

        System.out.println(solution(lectures));
    }
}
