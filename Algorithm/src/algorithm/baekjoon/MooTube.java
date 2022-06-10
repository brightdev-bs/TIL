package algorithm.baekjoon;

import java.util.*;

public class MooTube {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), Q = sc.nextInt();

        List<ArrayList<int[]>> list = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<int[]>());
        }

        for(int i = 0; i< N-1; i++) {
            int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
            list.get(p).add(new int[]{q, r});
            list.get(q).add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            int k =sc.nextInt(), v = sc.nextInt();

            boolean[] visit = new boolean[N + 1];
            visit[v] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            int answer = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int[] ele : list.get(cur)) {
                    if(!visit[ele[0]] && ele[1] >= k) {
                        queue.add(ele[0]);
                        visit[ele[0]] = true;
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
