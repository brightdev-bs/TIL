package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class P_1_reminder {

    static class Person implements Comparable<Person> {
        int height, weight;

        Person(int h, int w) {
            height = h;
            weight = w;
        }

        @Override
        public int compareTo(Person p) {
            if(this.height == p.height) {
                return p.weight - this.weight;
            } else {
                return p.height - this.height;
            }
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            people[i] = new Person(h,w);
        }

        Arrays.sort(people);

        int max = -1;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(people[i].weight > max) {
                count++;
                max = people[i].weight;
            }
        }

        System.out.println(count);

    }
}
