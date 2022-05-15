package bruteForce;

import java.sql.SQLOutput;
import java.util.Scanner;

public class B1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e = sc.nextInt() - 1;
        int s = sc.nextInt() - 1;
        int m = sc.nextInt() - 1;

        int year = 0;
        while(true) {
            if(year % 15 == e && year % 28 == s  && year % 19 == m) {
                System.out.println(year + 1);
                break;
            }
            year++;
        }
    }
}
