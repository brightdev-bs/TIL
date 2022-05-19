package divisor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B17425RR {

    public static final int MAX = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] memory = new long[MAX];
        Arrays.fill(memory, 1);

        for(int i = 2; i < MAX; i++) {
            for(int j = 1; i * j < MAX; j++) {
                memory[i * j] += i;
            }
        }

        long[] answer = new long[MAX];
        for(int i = 1; i < MAX; i++) {
            answer[i] += answer[i-1] + memory[i];
        }

        int n = sc.nextInt();
        while(n-- > 0) {
            int input = sc.nextInt();
            System.out.println(answer[input]);
        }
    }
}
