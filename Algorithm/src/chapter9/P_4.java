package chapter9;

import java.util.*;

public class P_4 {

    static int n;

    static class Lecture implements Comparable<Lecture> {
        int payment, due;

        public Lecture(int payment, int due) {
            this.payment = payment;
            this.due = due;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.due - this.due;
        }
    }

    public static int solution(List<Lecture> list) {
        // 해결해야 할 문제 상황 --> count를 도입해서 due와 비교할려고 했는데 로직에 문제가 있음.
        // 일단 금액 순으로 나열이 되어 있는데 금액이 아니라 due에 우선순위를 두어야 할 것 같음. why?
        // -> due를 기준으로 오름차순 정리를 한 다음에 하면 안되네?
        // -> 새로운 문제 상황 --> due를 기준으로 오름차순 하면 가장 높은 급여를 받을 수 없음.
        // -> how can i sovle it? 우선순위 큐를 이용한다.
        int max = list.get(0).due;
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());  // 큰 수를 기준으로 하는 우선순위 큐
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < n; j++) {
                if(list.get(j).due < i) break;
                pQ.offer(list.get(j).payment);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        ArrayList<Lecture> lectures = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();
            lectures.add(new Lecture(p,d));
        }

        Collections.sort(lectures);
        System.out.println(solution(lectures));

    }
}
