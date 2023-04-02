package ch6;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant[] garden = new Plant[6];
        garden[0] = new Plant("1번", LifeCycle.ANNUAL);
        garden[1] = new Plant("2번", LifeCycle.PERENNIAL);
        garden[2] = new Plant("3번", LifeCycle.BIENNIAL);
        garden[3] = new Plant("4번", LifeCycle.PERENNIAL);
       System.out.println(Arrays.stream(garden)
               .collect(groupingBy(p -> p.lifeCycle,
                       () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}
