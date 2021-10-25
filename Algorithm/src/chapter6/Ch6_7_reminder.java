package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_7_reminder {
    static class Point implements Comparable<Point> {
        int x,y;

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x)
                return this.y - o.y;
            else
                return this.x - o.x;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Point[] p = new Point[n];

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p[i] = new Point(x, y);
        }

        Arrays.sort(p);

        for(Point tmp : p) {
            System.out.println(tmp.x + " " + tmp.y);
        }
    }
}
