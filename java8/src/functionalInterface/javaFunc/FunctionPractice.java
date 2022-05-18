package functionalInterface.javaFunc;

import java.util.function.Function;

public class FunctionPractice {

    public static void main(String[] args) {
        Function<Integer, Integer> plus = (num) -> num + 5;
        Function<Integer, Integer> multiply = (num) -> num * 2;
        Function<String, String> world = (s) -> s + " world";

        System.out.println(plus.apply(5));
        System.out.println(multiply.apply(5));
        System.out.println(world.apply("hello"));

        // compose
        Function<Integer, Integer> mulAndPlus = plus.compose(multiply);
        System.out.println(mulAndPlus.apply(5));

        // andThen
        Function<Integer, Integer> plusAndMul = plus.andThen(multiply);
        System.out.println(plusAndMul.apply(5));
    }
}
