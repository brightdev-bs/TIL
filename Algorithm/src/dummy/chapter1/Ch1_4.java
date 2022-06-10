package dummy.chapter1;

import java.util.Scanner;

public class Ch1_4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            sb.setLength(0);
            sb.append(s);
            System.out.println(sb.reverse());
        }
    }
}
