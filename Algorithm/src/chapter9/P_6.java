package chapter9;

import java.util.ArrayList;
import java.util.Scanner;

public class P_6 {

    static int[] ch;

    static class Relation {
        int first, second;

        public Relation(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int find(int f1) {
        if(ch[f1] == f1) return f1;
        else return find(ch[f1]);
    }
    
    public static void solution(int f1, int f2, ArrayList<Relation> list) {
        for(Relation r : list) {
            int v1 = find(r.first);
            int v2 = find(r.second);
            if(v1 != v2)  ch[v1] = v2;
        }

        if(find(ch[f1]) == find(ch[f2])) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            ch[i] = i;
        }

        ArrayList<Relation> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            list.add(new Relation(f, s));
        }

        int f1 = sc.nextInt();
        int f2 = sc.nextInt();

        solution(f1, f2, list);

    }
}
