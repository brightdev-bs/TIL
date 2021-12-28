package language;

import java.util.stream.Stream;

public class StreamIterate {

    public static void main(String[] args) {
        Stream<Integer> numStream = Stream.iterate(0, n -> n + 2);
        numStream.limit(10).forEach(System.out::println);
    }
}
