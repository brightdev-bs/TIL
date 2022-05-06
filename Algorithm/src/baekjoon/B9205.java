package baekjoon;

import java.util.Scanner;

public class B9205 {

    static Point sangen, festival;
    static Point[] store;
    static final int DISTANCE = 20 * 50;
    static boolean flag = false;
    static boolean[] visited;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 개수
        for(int i = 0; i < t; i++) {
            flag = false;
            int n = sc.nextInt(); // 편의점 수
            store = new Point[n];
            sangen = new Point(sc.nextInt(), sc.nextInt()); // 상근이 좌표
            for(int j = 0; j < n; j++) {
                store[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            festival = new Point(sc.nextInt(), sc.nextInt());

            visited = new boolean[n];
            solution(sangen.x, sangen.y);

            if(flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static void solution(int curX, int curY) {
        if(flag) return;

        if(Math.abs(curX - festival.x) + Math.abs(curY - festival.y) <= DISTANCE) {
            flag = true;
            return;
        }

        // 편의점
        for(int i = 0; i < store.length; i++) {
            if(visited[i]) continue;

            if(Math.abs(curX - store[i].x) + Math.abs(curY - store[i].y) > DISTANCE) continue;

            visited[i] = true;
            solution(store[i].x, store[i].y);
        }
    }
}
