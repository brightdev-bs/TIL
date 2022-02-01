package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class P_1 {
    static int count = 0;

    static class People implements Comparable<People> {
        int height, weight;

        public People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(People o) {
            if(this.height == o.height)
                return o.weight - this.weight;
            else
                return o.height - this.height;
        }
    }

    public static void solution(People[] peoples) {
        Arrays.sort(peoples);
        int max = Integer.MIN_VALUE;
        for(People p : peoples) {
            if(p.weight >max) {
                max = p.weight;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        People[] peoples = new People[input];

        for(int i = 0; i < input; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            peoples[i] = new People(h,w);
        }

        solution(peoples);
        System.out.println(count);
    }
}
