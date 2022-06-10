package dummy.chapter9;

import java.util.Arrays;
import java.util.Comparator;

public class SortEx {

    static class Person implements Comparator<Person> {
        int height, weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compare(Person o1, Person o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 5, 2, 9, 1};
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));

        Person[] p = new Person[3];
        p[0] = new Person(170,60);
        p[1] = new Person(175, 65);
        p[2] = new Person(180, 70);


    }
}
