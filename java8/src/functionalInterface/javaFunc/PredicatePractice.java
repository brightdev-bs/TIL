package functionalInterface.javaFunc;

import java.util.function.Predicate;

public class PredicatePractice {

    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));
    }
}
