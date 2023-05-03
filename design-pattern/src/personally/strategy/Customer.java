package personally.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customer {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PayStrategy payStrategy;

    public static void main(String[] args) throws IOException {
        System.out.println("1번 : 네이버페이\n2번 : 일반 카드");
        Integer input = Integer.parseInt(br.readLine());

        if(input == 1) {
            payStrategy = new NeverPay("vanille@naver.com", "personally/strategy");
        } else {
            payStrategy = new CreditCard("1111-2222-3333-4444", 457, "VNCard");
        }

        payStrategy.pay(5000);
    }
}
