package Chapter7;

/**
 * 8월 19일 복습.
 */
import java.util.Scanner;

public class Main{

    public void recursive(int n) {
        if(n == 1) {
            System.out.print(1 + " ");
        }
        else {
            recursive(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String args[]) {
        Main T = new com.mango.ch7.Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        T.recursive(n);
    }
}