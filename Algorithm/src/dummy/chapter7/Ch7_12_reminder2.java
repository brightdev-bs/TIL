package dummy.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch7_12_reminder2 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> list;
    static int[] ch, dis;

    public static void BFS(int length) {
        ch[1] = 1;
        dis[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nx : list.get(cv)) {
                if(ch[nx] == 0) {
                    ch[nx] = 1;
                    dis[nx] = dis[cv] + 1;
                    queue.add(nx);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];
        dis = new int[n+1];
        list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }

        BFS(0);
        for(int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }

    }
}
