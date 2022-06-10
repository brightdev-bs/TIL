package dummy.chapter9;

import java.util.ArrayList;
import java.util.Scanner;

public class P_6_remind {
    static ArrayList<Relation> list;
    static int[] ch;

    static class Relation {
        int first, second;

        public Relation(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int find(int num) {
        if(ch[num] == num) return num;
        else return find(ch[num]);
    }

    public static void solution(int f1, int f2) {
        for(Relation r : list) {
            int a = find(r.first);
            int b = find(r.second);
            if(a != b) ch[b] = a;
        }

        if(ch[f1] == ch[f2]) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        ch = new int[n+1];
        for(int i = 0; i <= n; i++) {
            ch[i] = i;
        }

        list = new ArrayList<>();
        for(int i = 0; i < m - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Relation(a, b));
        }

        int f1 = sc.nextInt();
        int f2 = sc.nextInt();

        solution(f1, f2);
    }
}
