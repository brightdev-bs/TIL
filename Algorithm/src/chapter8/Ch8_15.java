package chapter8;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch8_15 {
    static int[][] board;
    static ArrayList<Point> home, pizza;
    static int[] combi;
    static int limit, size, answer = Integer.MAX_VALUE;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int L, int s) {
        if(L == limit) {
            int sum = 0;
            for(Point h : home) {
                int dis = Integer.MAX_VALUE;
                for(int n : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(n).x) + Math.abs(h.y - pizza.get(n).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s; i < pizza.size(); i++) {
                combi[L] = i;
                DFS(L+1, s+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        limit = sc.nextInt();

        board = new int[size + 1][size + 1];
        combi = new int[limit];
        home = new ArrayList<>();
        pizza = new ArrayList<>();

        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                int input = sc.nextInt();
                board[i][j] = input;
                if(input == 1) home.add(new Point(i, j));
                else if(input == 2) pizza.add(new Point(i,j));
            }
        }

        DFS(0,0);
        System.out.println("answer = " + answer);
    }
}
