package dummy.chapter3;

import java.util.Scanner;

public class Ch3_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0, answer = 0, lt = 0;
        for(int i = 1; i < n; i++) {
            sum += i;
            if(sum == n) answer++;
            while(sum > n) {
                sum -= lt++;
                if(sum == n)answer++;
            }
        }

        System.out.println(answer);
    }
}
