package divisor;

import java.io.*;
import java.util.Scanner;

public class B17425RRR {

    static final int SIZE = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] arr = new long[SIZE];
        long[] answer = new long[SIZE];

        // f(A)를 구하는 과정
        for(int i = 1; i < SIZE; i++) {
            for(int j = i; j < SIZE; j = j + i) {
                arr[j] += i;
            }
        }

        // g(A) 구하기
        for(int i = 1; i < SIZE; i++) {
            answer[i] = answer[i-1] + arr[i];
        }

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int input = Integer.parseInt(br.readLine());
            bw.write(answer[input] + "\n");
        }

        bw.flush();
    }
}
