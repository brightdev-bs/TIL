package dummy.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {

    int height, weight;
    Person(int h, int w) {
        height = h;
        weight = w;
    }

    @Override
    public int compareTo(Person o) {
        return o.height - this.height;
    }
}

public class Ch9_1 {
    public static int max = Integer.MIN_VALUE;
    public static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Person> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Person(h, w));
        }

        Collections.sort(arr);

        for(int j = 0; j < n; j++) {
            if(arr.get(j).weight > max) {
                answer++;
                max = arr.get(j).weight;
            }
        }

        System.out.println(answer);
    }
}
