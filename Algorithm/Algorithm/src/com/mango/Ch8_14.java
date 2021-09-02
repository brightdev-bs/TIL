package com.mango;

import java.util.*;

public class Ch8_14 {
    public static int n,m, dis, answer = Integer.MAX_VALUE;
    public static int[][] board;
    public static ArrayList<Point> pizza = new ArrayList<>();
    public static ArrayList<Point> house = new ArrayList<>();
    public static int[] combi;

    public static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int index, int start) {
        if(index == m) {
            int sum = 0;
            for(Point h : house) {
                dis=Integer.MAX_VALUE;
                for (int idx : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(idx).x) + Math.abs(h.y - pizza.get(idx).y));
                }
                sum+=dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = start; i < pizza.size(); i++) {
                combi[index] = i;
                DFS(index+1, start+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];

        // 입력 받기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) house.add(new Point(i,j));
                if(tmp == 2) pizza.add(new Point(i,j));
            }
        }

        combi = new int[m];

        DFS(0,0);

        System.out.println(answer);
    }
}
