package dataStructure;

import java.util.*;

public class Dijkstra01 {

    static class Node {
        int idx, value;

        public Node(int nextNode, int value) {
            this.idx = nextNode;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(); // n = 정점, m = 간선

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        List<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i < 9; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int v = sc.nextInt();
            list.get(a).add(new Node(b, v));
        }

        // 값 구하기 시작
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        dis[1] = 0;
        queue.add(1);
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now);
            for(Node node : list.get(now)) {
                if(node.value + dis[now] < dis[node.idx]) {
                    dis[node.idx] = node.value + dis[now];
                    queue.add(node.idx);
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE) System.out.print(dis[i] + " ");
        }
    }
}
