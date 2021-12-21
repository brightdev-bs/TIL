package chapter7;

import java.util.LinkedList;
import java.util.Queue;

public class Ch7_7_reminder {
    Node root;

    static class Node{
        int data;
        Node lt, rt;
        public Node(int val) {
            data=val;
            lt=rt=null;
        }
    }

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                System.out.print(tmp.data + " ");
                if(tmp.lt != null) queue.add(tmp.lt);
                if(tmp.rt != null) queue.add(tmp.rt);
            }
        }
    }

    public static void main(String[] args) {
        Ch7_7_reminder tree = new Ch7_7_reminder();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root);
    }
}
