package com.mango;

import java.util.*;

public class Main {
    Node root;

    // 전위 순회
    /*
    public void DFS(Node node) {
        System.out.println(node.data);
        if(node.lt != null)
            DFS(node.lt);
        if(node.rt != null)
            DFS(node.rt);
    }
    */

    // 중위순회
    /*
    public void DFS(Node node) {
        if(node.lt != null)
            DFS(node.lt);
        System.out.println(node.data);
        if(node.rt != null)
            DFS(node.rt);
    }
     */

    // 후위순회

    public void DFS(Node node){
        if(node==null) return;
        else {
            DFS(node.lt);
            DFS(node.rt);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        Main tree=new Main();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);
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

