package dummy.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

class Ch7_11 {
    public static ArrayList<ArrayList<Integer>> list;
    public static int n,m, answer = 0;
    public static int[] ch;

    public static void solution(int idx) {
        if(idx == n) {
            answer++;
        } else {
            int size = list.get(idx).size();
            for(int i = 0; i < size; i++) {
                int num = list.get(idx).get(i);
                if(ch[num] == 0) {
                    ch[num] = 1;
                    solution(num);
                    ch[num] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ch = new int[n+1];

        list = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
        }

        ch[1] = 1;
        solution(1);
        System.out.println(answer);
    }
}
