package ch2;

import java.math.BigDecimal;

public class ComparablePractice {

    public static void main(String[] args) {
        BigDecimal n1 = new BigDecimal("1.0");
        BigDecimal n2 = new BigDecimal("1.00");

        System.out.println(n1.compareTo(n2));
        System.out.println(n1.equals(n2));

    }
}
