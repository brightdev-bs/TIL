package divisor;

import java.io.*;
import java.util.Scanner;

public class B17425 {

    public static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] memory = new long[MAX+1];
        long[] s = new long[MAX + 1];

        for(int i = 1; i <= MAX; i++) {
            memory[i] = 1;
        }

        for(int i = 2; i <= MAX; i++) {
            for(int j = 1; i * j <= MAX; j++) {
                memory[i * j] += i;
            }
        }

        for(int i = 1; i <= MAX; i++) {
            s[i] = s[i-1] + memory[i];
        }

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write(s[num] + "\n");
        }
        bw.flush();
    }
}
