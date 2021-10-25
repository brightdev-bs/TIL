package chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_5_reminder {

    public static char solution(int[] arr) {
//        이렇게 하면 시간 초과 -> 따라서 정렬 한 후 처리
//        char answer = 'U';
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(int x : arr) {
//            if(!list.contains(x)) list.add(x);
//            else answer = 'D';
//        }
//
//        return answer;

        char answer = 'U';
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]) answer = 'D';
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
}
