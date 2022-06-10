package algorithm.baekjoon;

import java.util.*;

public class B1987 {
    public static int[] dx = { -1 , 0, 0 , 1};
    public static int[] dy = { 0, -1, 1, 0 };
    public static int r, c;
    public static char[][] board;
    public static int answer = 0;
    public static int[] ch = new int[26];

    public static void DFS(int x, int y, int d) {
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < r && 0 <= ny && ny < c && ch[board[nx][ny] - 'A'] == 0) {
                ch[board[nx][ny] - 'A'] = 1;
                DFS(nx, ny, d + 1);
                ch[board[nx][ny] - 'A'] = 0;
            }
        }
        answer = Math.max(answer, d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        board = new char[r][c];

        for(int i = 0; i < r; i++) {
            String s = sc.next();
            for(int j = 0; j < c; j++){
                board[i][j] = s.charAt(j);
            }
        }

        ch[board[0][0] - 'A'] = 1;

        DFS(0,0, 1);
        System.out.println(answer);
    }
}
