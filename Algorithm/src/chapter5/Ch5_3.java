package chapter5;

import java.util.Scanner;
import java.util.Stack;

public class Ch5_3 {

    public static int solution(int[][] board, int n, int[] moves, int m) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int x : moves) {
            for(int i = 1; i <= n; i++) {
                if(board[i][x] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][x]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][x]);
                    }
                    board[i][x] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(solution(board, n, moves, m));
    }
}
