package functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MethodReferencePractice {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.forEach(System.out::println);
    }
}
