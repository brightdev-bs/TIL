import java.util.LinkedList;
import java.util.Queue;

public class Ch7_9_BFS_reminder {
    static Node root;

    public static void main(String[] args) {
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        System.out.println(BFS(0, root));
    }

    public static int BFS(int length, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if(cur.lt == null && cur.rt == null) return length;
                if(cur.lt != null) queue.add(cur.lt);
                if(cur.rt != null) queue.add(cur.rt);
            }
            length++;
        }
        return -1;
    }
}

class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}
