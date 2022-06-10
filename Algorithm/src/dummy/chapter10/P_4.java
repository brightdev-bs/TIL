package dummy.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P_4 {

    static int[] dy;
    static int answer;

    static class Stone implements Comparable<Stone> {
        int id, area, height, weight;

        public Stone(int id, int area, int height, int weight) {
            this.id = id;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Stone o) {
            if(this.area == o.area)
                return o.height - this.height;
            else
                return o.area - this.area;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n];

        List<Stone> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Stone(i, a,h,w));
        }

        Collections.sort(list);

        dy[0] = list.get(0).height;
        answer = dy[0];
        for(int i = 1; i < n; i++) {
            int max_h = 0;
            for(int j = i-1; j >= 0; j--) {
                if(list.get(j).weight > list.get(j).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }
            dy[i] = max_h + list.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

    }
}
