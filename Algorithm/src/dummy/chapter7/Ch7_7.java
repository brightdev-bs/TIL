package dummy.chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Ch7_7 {
    public static Queue<Node> queue = new LinkedList<>();
    public static Node root;

    public static void solution(Node root) {
        queue.add(root);
        int length = 1;
        while(!queue.isEmpty()) {
            System.out.println("길이 : " + length++);
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                System.out.print(tmp.data + " ");
                if(tmp.lt != null)
                    queue.offer(tmp.lt);
                if(tmp.rt != null)
                    queue.offer(tmp.rt);
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);

        solution(root);
    }
}
