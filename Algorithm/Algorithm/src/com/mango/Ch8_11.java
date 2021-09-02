package com.mango;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Ch8_11 {
    public static int[] dx = { -1, 0, 0, 1};
    public static int[] dy = { 0, 1, -1, 0};
    public static int[][] board = new int[8][8];
    public static int[][] dis = new int[8][8];

    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        board[x][y] = 1;
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.add(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        BFS(1,1);

        if(dis[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);

    }
}
