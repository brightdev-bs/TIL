package dummy.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch6_9_reminder3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            list.add(input);
        }

        System.out.println(solution(list, n,m));
    }

    public static int solution(ArrayList<Integer> list, int n, int m) {
        int lt = Collections.max(list), rt = list.stream().mapToInt(i -> i).sum();
        int answer = -1;
        while(lt <= rt) {
            int middle = (lt + rt) / 2;
            if(count(list, middle) <= m) {
                answer = middle;
                rt = middle - 1;
            }
            else {
                lt = middle + 1;
            }
        }

        return answer;
    }

    public static int count(ArrayList<Integer> list, int capacity) {
        int count = 1, sum = 0;
        for(int n : list) {
            if(sum + n > capacity) {
                sum = n;
                count++;
            } else {
                sum += n;
            }
        }

        return count;
    }
}
