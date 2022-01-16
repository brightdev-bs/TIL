package chapter8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 토마모가 익지 못하는 상황 -1 구현해야함
public class Ch8_12 {
    static int[] dx = {-1, 0, 0, 1 }, dy = {0, -1, 1, 0};
    static int[][] box;
    static int col, row;
    static int answer = -1;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        answer = 0;

        boolean flag = false;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    flag = true;
                }
            }
        }

        if(!flag) {
            answer = 0;
            return;
        } else {
            while(!queue.isEmpty()) {
                answer++; // check
                int len = queue.size();
                for(int i = 0; i < len; i++) {
                    Point p = queue.poll();
                    for(int j = 0; j < 4; j++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];
                        if(nx >= 0 && nx < row && ny >= 0 && ny < col && box[nx][ny] == 0) {
                            queue.add(new Point(nx, ny));
                            box[nx][ny] = 1;
                        }
                    }
                }
            }
        }
    }

    public static boolean stateCheck() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(box[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        col = sc.nextInt();
        row = sc.nextInt();

        box = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        BFS();

        if(stateCheck())
            System.out.println(answer-1);
        else
            System.out.println(-1);

//        System.out.println(Arrays.deepToString(box));
    }
}
