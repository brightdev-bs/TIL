package dummy.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Ch7_9 {
    public static Node start;
    public static int length = 0;

    public static int solution(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                if(tmp.lt == null && tmp.rt == null) {
                    return length;
                }
                if(tmp.lt != null) queue.offer(tmp.lt);
                if(tmp.rt != null) queue.offer(tmp.rt);
            }
            length++;
        }
        return -1;
    }

    public static void main(String[] args) {
        start = new Node(1);
        start.lt = new Node(2);
        start.lt.lt = new Node(4);
        start.lt.rt = new Node(5);
        start.rt = new Node(3);

        System.out.println( solution(start));
    }
}
