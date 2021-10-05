package chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch7_12 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> list;
    static int[] ch;

    public static void solution(int idx) {
        int len = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int num = queue.poll();
                for(int x : list.get(num)) {
                    if(len < ch[x]) {
                        ch[x] = len;
                        queue.add(x);
                    }
                }
            }
            len++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];
        for(int i = 0; i <= n; i++) {
            ch[i] = Integer.MAX_VALUE;
        }

        list = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }

        solution(1);

        for(int i = 2; i < ch.length; i++) {
            System.out.println(i + " : " + ch[i]);
        }
    }
}
