package chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch10_4 {
    static class Blick implements Comparable<Blick> {
        int area, height, weight;
        Blick(int a, int h, int w) {
            area = a;
            height = h;
            weight = w;
        }

        @Override
        public int compareTo(Blick o) {
            return o.area - this.area;
        }
    }

    public static ArrayList<Blick> list;
    public static int[] dy;

    public static int solution(int n) {
        dy[0] = list.get(0).height;
        int answer = dy[0];
        for(int i = 1; i < n; i++) {
            Blick tmp = list.get(i);
            int max = 0;
            for(int j = i - 1; 0 <= j; j--) {
                Blick tmp2 = list.get(j);
                if(tmp.weight < tmp2.weight && max < dy[j]) {
                    max = dy[j];
                }
            }
            dy[i] = max + tmp.height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n];
        list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            list.add(new Blick(area, height, weight));
        }

        Collections.sort(list);

        System.out.println(solution(n));
    }
}
