package baekjoon;

import java.util.*;

public class B7569 {

    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    static int[][][] ch, box;
    static int m,n,h;
    static List<Point> list;

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
        list = new ArrayList<>();

        // 입력 받기 - 박스의 아래부터 저장해야 하므로 n-1부터 시작
        for(int k = h-1; k >= 0; k--) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int t = sc.nextInt();
                    box[k][i][j] = t;
                    if (t == 1) list.add(new Point(k,i,j));
                }
            }
        }

        int answer = BFS();

        printBox(m, n, h, box);

        if(checkTomato()) System.out.println(answer);
        else System.out.println(-1);
    }

    private static boolean checkTomato() {
        for(int k = h -1; k >= 0; k--) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if(ch[k][i][j] == 0) return false;
                }
                System.out.println();
            }
        }
        return true;
    }

    private static void printBox(int m, int n, int h, int[][][] box) {
        for(int k = h -1; k >= 0; k--) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(box[k][i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    // 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 x
    // 토마토는 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향으로 익게 만든다.
    public static int BFS() {
        Queue<Point> q = new LinkedList<>();
        for (Point point : list) {
            q.add(point);
        }

        int answer = 0;
        while(!q.isEmpty()) {
            answer++;
            int len = q.size();
            for(int i = 0; i < len; i++) {
                Point tmp = q.poll();

                // 위, 아래
                int h = tmp.h;
                while(h - n >= 0) {
                    q.add(new Point(h-n, tmp.x, tmp.y));
                    ch[h-n][tmp.x][tmp.y] = 1;
                    h = h - n;
                }

                // 나머지
                for(int j = 0; j < dx.length; j++) {
                    for(int k = 0; k < dy.length; k++) {
                        int nx = tmp.x - dx[j];
                        int ny = tmp.y - dy[j];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && ch[tmp.h][nx][ny] == 0 && box[tmp.h][nx][ny] != -1) {
                            ch[tmp.h][nx][ny] = 1;
                            box[tmp.h][nx][ny] = 1;
                            q.add(new Point(tmp.h, nx, ny));
                        }
                    }
                }
            }
        }

        // -1은 방문 못하는걸로 해야함.
        return answer;
    }
}
