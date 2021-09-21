package Chapter1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch1_4_2 {
    public static ArrayList<String> solution(String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s : arr) {
            char[] c = s.toCharArray();
            int lt = 0, rt = c.length-1;
            while(lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++; rt--;
            }
            String tmp = String.valueOf(c);
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr =new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for(String x : solution(arr)) {
            System.out.println(x);
        }
    }
}
