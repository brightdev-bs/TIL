package com.mango;

/**
 * 8월 20일 복습.
 */
import java.util.Scanner;

class Node {
    int data;
    Node lt, rt;
    Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main{
    Node root;
    void DFS(Node node) {
        if(node == null) return;
        else {
            //System.out.printf("%d ", node.data);
            DFS(node.lt);
            //System.out.printf("%d ", node.data);
            DFS(node.rt);
            System.out.printf("%d ", node.data);
        }
    }

    public static void main(String args[]) {
        Main tree = new Main();
        Scanner sc = new Scanner(System.in);

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