package language;

import java.util.Random;
import java.util.stream.IntStream;

public class StreamRandomGenerator {

    public static void main(String[] args) {
        IntStream intStream = new Random().ints();
        intStream.limit(3).forEach(System.out::println);

//        IntStream intStream2 = IntStream.rangeClosed(1, 10);
//        intStream2.forEach(System.out::println);

        IntStream intStream3 = new Random().ints(1, 10);
        intStream3.limit(3).forEach(System.out::println);
    }
}
