package dummy.chapter10;

// 다이나믹 프로그래밍
// -> 20짜리 크기를 1개로 소형화시키고, 2개, 3개로 확장시킴(메모이제이션도 활용)
// 나는 dfs로 풀었는데 인강에서는 다이나믹으로 품.
import java.util.Scanner;

public class Ch10_1 {
    public static int answer = 0;

    public static void DFS(int n, int m) {
        if(n == m) answer++;
        else if(n > m) return;
        else {
            DFS(n + 1, m);
            DFS(n+2, m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DFS(1, n);
        DFS(2, n);

        System.out.println(answer);
    }
}
