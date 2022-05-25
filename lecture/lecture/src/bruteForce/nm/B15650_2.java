package bruteForce.nm;

import java.util.Scanner;

// 선택 방법으로 풀기
public class B15650_2 {

    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(1, 0, n, m);
    }

    public static void solution(int index, int select, int n, int m) {
        if(select == m) {
            for(int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        if(index > n) return;
        a[select] = index;
        solution(index + 1, select + 1, n, m);
        a[select] = 0;
        solution(index + 1, select, n, m);
    }
}
