package dataStructure;

import java.util.*;

public class MST01 {

    static int[] ch;
    static List<ArrayList<Node>> list;

    static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static int solution(int v) {
        int answer = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int index = now.v;
            if(ch[index] == 0) {
                ch[index] = 1;
                answer += now.cost;
                for (Node tmp : list.get(index)) {
                    if (ch[tmp.v] == 0) queue.add(tmp);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(), e = sc.nextInt();
        ch = new int[v + 1];

        list = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }

        System.out.println(solution(1));


    }
}
