package mod;

import java.util.Scanner;

public class B4375R {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int input = sc.nextInt();
            int n = 0;
            for(int i = 1; ; i++) {
                n = n * 10 + 1;
                n = n % input;
                if(n == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
