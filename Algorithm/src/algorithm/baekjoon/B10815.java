package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B10815 {

    static int n,m;
    static int[] arr, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 상근이가 가지고 있는 숫자 카드

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        m = sc.nextInt(); // m개의 숫자
        answer = new int[m];

        for(int i = 0; i < m; i++) {
            int input = sc.nextInt();
            solution(i, input);
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static void solution(int idx, int target) {
        int lt = 0, rt = n - 1;
        int middle;
        while(lt <= rt) {
            middle = (lt + rt) / 2;
            if(arr[middle] == target) {
                answer[idx] = 1;
                return;
            }
            else if(arr[middle] > target) rt = middle - 1;
            else lt = middle + 1;
        }
    }
}
