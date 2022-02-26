package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class B10021 {

    static double[][] dis;

    static class Field {
        int x, y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // N field
        int m = sc.nextInt(); // at least
        dis = new double[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        List<Field> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            list.add(new Field(x, y));
        }

        for(int i = 0; i < n-1; i++) {
            int cx = list.get(i).x, cy = list.get(i).y;
            for(int j = i + 1; j < n; j++) {
                int tx = list.get(j).x, ty = list.get(j).y;
                double area = Math.pow(abs(cx - tx), 2) + pow(abs(cy - ty), 2);
                if(dis[i][j] > area && area >= m) {
                    dis[i][j] = area;
                    dis[j][i] = area;
                }
            }
        }

        System.out.println(Arrays.deepToString(dis));
    }
}
