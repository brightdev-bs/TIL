package algorithm.baekjoon;

import java.util.*;

public class B7569 {

    static int dx[] = {-1, 0, 0, 1, 0, 0};
    static int dy[] = {0, -1, 1, 0, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};

    static int[][][] ch, box;
    static int m,n,h;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int h, x, y;

        public Point(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); // 가로칸 수
        n = sc.nextInt(); // 세로칸 수
        h = sc.nextInt(); // 상자의 수

        box = new int[h][n][m];
        ch = new int[h][n][m];

        // 입력 받기 - 박스의 아래부터 저장해야 하므로 n-1부터 시작
        for(int k = h-1; k >= 0; k--) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int t = sc.nextInt();
                    box[k][i][j] = t;
                    if (t == 1) q.add(new Point(k,i,j));
                }
            }
        }

        BFS();

        if(checkTomato()) System.out.print(findLastDay());
        else System.out.print(-1);
    }

    private static int findLastDay() {
        int answer = Integer.MIN_VALUE;
        for(int i = h-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                for(int k = m-1; k >= 0; k--) {
                    answer = Math.max(answer, ch[i][j][k]);
                }
            }
        }
        return answer;
    }

    private static boolean checkTomato() {
        for(int k = h -1; k >= 0; k--) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if(box[k][i][j] == 0) return false;
                }
            }
        }
        return true;
    }

    // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 x
    // 토마토는 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향으로 익게 만든다.
    public static void BFS() {
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int nx = tmp.x - dx[i];
                int ny = tmp.y - dy[i];
                int nh = tmp.h - dz[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h && box[nh][nx][ny] == 0) {
                    box[nh][nx][ny] = 1;
                    q.add(new Point(nh, nx, ny));
                    ch[nh][nx][ny] = ch[tmp.h][tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}
