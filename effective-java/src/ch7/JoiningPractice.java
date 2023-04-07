package ch7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class JoiningPractice {

    public static void main(String[] args) {
        List<String> str = new ArrayList<>(List.of("1", "2", "#"));

        String result = str.stream().collect(joining());
        System.out.println(result); // 12#

        String result2 = str.stream().collect(joining(","));
        System.out.println(result2); // 1,2,#

        String result3 = str.stream().collect(joining(",", "[", "]"));
        System.out.println(result3); // [1,2,#]
    }
}
