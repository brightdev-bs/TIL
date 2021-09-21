package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_4 {
    public static int[] ch = new int[10001];
    public static int max;
    static class Plan implements Comparable<Plan> {
        int money, due;
        Plan(int m, int d) {
            money = m;
            due = d;
        }

        @Override
        public int compareTo(Plan o) {
            return o.due - this.due;
        }
    }

    public static int solution(ArrayList<Plan> list) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int j = 0;
        for(int i = max; i >= 1; i--) {
            for(; j < list.size(); j++) {
                if(list.get(j).due < i) break;
                priorityQueue.add(list.get(j).money);
            }
            if(!priorityQueue.isEmpty()) {
                sum += priorityQueue.poll();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        max = Integer.MIN_VALUE;

        ArrayList<Plan> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arrayList.add(new Plan(m, d));
            if(max < d) max = d;
        }

        Collections.sort(arrayList);

        System.out.println(solution(arrayList));
    }
}
