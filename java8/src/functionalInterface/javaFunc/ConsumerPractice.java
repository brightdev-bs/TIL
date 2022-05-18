package functionalInterface.javaFunc;

import java.util.function.Consumer;

public class ConsumerPractice {

    public static void main(String[] args) {
        Consumer<String> print = s -> System.out.println(s + " hello world");
        print.accept("KIM");
    }
}
