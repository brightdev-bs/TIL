package dummy.chapter10;

import java.util.Scanner;

public class Ch10_3_복습 {
    public static int[] dy;
    public static int[] arr;

    public static int solution(int n) {
        int answer = 0;
        dy[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = i-1; 0 <= j; j--) {
                if(arr[j] < arr[i] && max < dy[j]) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];
        dy = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n));
    }
}
