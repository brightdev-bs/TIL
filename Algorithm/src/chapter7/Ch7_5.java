package chapter7;
class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}

public class Ch7_5 {
    public static Node root;

    public static void DFS(Node node) {
        if(node == null) return;
        System.out.print(node.data + " ");
        DFS(node.lt);
        DFS(node.rt);
    }


    public static void DFS2(Node node) {
        if(node == null) return;
        DFS2(node.lt);
        System.out.print(node.data + " ");
        DFS2(node.rt);
    }

    public static void DFS3(Node node) {
       if(node == null) return;
        DFS3(node.lt);
        DFS3(node.rt);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        root.rt.lt=new Node(6);
        root.rt.rt=new Node(7);
        System.out.print("전위 순회 : ");
        DFS(root);
        System.out.println();
        System.out.print("중위 순회 : ");
        DFS2(root);
        System.out.println();
        System.out.print("후위 순회 : ");
        DFS3(root);
    }
}
