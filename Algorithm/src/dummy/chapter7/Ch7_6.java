package dummy.chapter7;

import java.util.Scanner;

public class Ch7_6 {
    public static int[] ch;
    public static int[] arr;
    public static int n;

    public static void solution(int l) {
        if(l == n+1) {
            String answer = "";
            for(int i = 1; i <= n; i++) {
                if(ch[i] != 0) answer += arr[i] + " ";
            }
            System.out.println(answer);
        } else {
            ch[l] = 1;
            solution(l+1);
            ch[l] = 0;
            solution(l+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ch = new int[n+1];
        arr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        solution(1);
    }
}
