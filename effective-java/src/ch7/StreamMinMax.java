package ch7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class StreamMinMax {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 10, 15, 26, 30, 100));
        Integer min = nums.stream().min(Comparator.comparingInt(a -> a)).get();
        Integer max = nums.stream().max(Comparator.comparingInt(a -> a)).get();
        System.out.println(min);
        System.out.println(max);
    }
}
