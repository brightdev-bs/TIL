package bruteForce;

import java.util.Scanner;

public class B6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n-- > 0) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            boolean ok = false;
            for(int k = x; k < (M*N); k += M) {
                if(k % N == y) {
                    System.out.println(k+1);
                    ok = true;
                    break;
                }
            }

            if(!ok) {
                System.out.println(-1);
            }
        }
    }
}
