package bruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class B2309R {

    static final int NUM = 9;

    static int[] dwarf = new int[NUM];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for(int i = 0; i < NUM; i++) {
            dwarf[i] = sc.nextInt();
            sum += dwarf[i];
        }

        Arrays.sort(dwarf);

        for(int i = 0; i < NUM; i++) {
            for(int j = i+1; j < NUM; j++) {
                if(sum - dwarf[i] - dwarf[j] == 100) {
                    for(int k = 0; k < NUM; k++) {
                        if(i == k || j == k) continue;
                        System.out.println(dwarf[k]);
                    }
                    System.exit(0); // 이거 쓰는 이유가 답이 여러 개 일수도 있으니까 이를 제거하기 위함?
                }
            }
        }
    }
}
