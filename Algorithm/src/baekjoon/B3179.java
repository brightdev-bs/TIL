package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS
public class B3179 {

    static int[] dx = {-1, 0, 0, 1}, dy = {0, 1, -1, 0};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> swans = new LinkedList<>();

        int R = sc.nextInt(), C = sc.nextInt();
        sc.nextLine();

        char[][] lake = new char[R][C];

        for(int i = 0; i < R; i++) {
            int j = 0;
            String line = sc.nextLine();
            for(char c : line.toCharArray()) {
                if(c == '.') {
                    queue.add(new Point(i, j));
                }
                lake[i][j] = c;
                j++;
            }
        }


        int answer = -1;
        while(!queue.isEmpty()){
            answer++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Point p = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (lake[nx][ny] == 'X') {
                            lake[nx][ny] = '.';
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
