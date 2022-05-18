package functionalInterface.javaFunc;

import java.util.function.BiFunction;

public class BiFunctionPractice {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> plus = (num1, num2) -> num1 + num2;
        System.out.println(plus.apply(5, 1));
    }
}
