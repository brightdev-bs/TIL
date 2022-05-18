package functionalInterface.javaFunc;

import java.util.function.BinaryOperator;

public class BinaryOperatorPractice {

    public static void main(String[] args) {
        BinaryOperator<Integer> plus = (n1, n2) -> n1 + n2;
        System.out.println(plus.apply(5, 10));
    }
}
