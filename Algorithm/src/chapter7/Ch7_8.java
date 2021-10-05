package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch7_8 {
    public static int[] ch = {1, -1, 5};
    public static int[] memory = new int[100001];

    public static int BFS(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int length = 0;
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == m) {
                    return length-1;
                }
                for(int j = 0; j < ch.length; j++) {
                    int nx = x+ch[j];
                    if(1 <= nx && nx <= 10000 && memory[nx] == 0) {
                        memory[x + ch[j]] = 1;
                        queue.offer(x + ch[j]);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(BFS(n,m));
    }
}
