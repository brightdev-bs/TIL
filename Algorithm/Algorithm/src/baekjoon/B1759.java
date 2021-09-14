package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B1759 {
    public static int[] ch;
    public static Character[] arr;
    public static int L, C;

    public static void solution(int length, int index) {
        if(length == L) {
            String answer = "";
            int v = 0; int cnt = 0;
            for(int i = 0; i < C; i++) {
                if(ch[i] == 1) {
                    answer += arr[i];
                    if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
                        v++;
                    else
                        cnt++;
                }
            }
            if(1 <= v && 2 <= cnt) {
                System.out.println(answer);
            }
        } else {
            for(int i = index; i < C; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    solution(length + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        arr = new Character[C];
        ch = new int[C];

        //숫자 입력받기
        for(int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);

        solution(0,0);
    }
}
