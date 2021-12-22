public class Ch7_9_DFS_reminder {

    static Node root;

    public static void main(String[] args) {
        root=new Node(1);
        root.lt=new Node(2);
        root.rt=new Node(3);
        root.lt.lt=new Node(4);
        root.lt.rt=new Node(5);
        System.out.println(DFS(0, root));
    }

    public static int DFS(int length, Node root) {
        if(root.lt == null && root.rt == null) return length;
        else return Math.min(DFS(length+1, root.lt), DFS(length+1, root.rt));
    }
}
