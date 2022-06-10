package dummy.chapter6;

import java.util.Arrays;
import java.util.Scanner;

public class Ch6_8 {
    public static int[] arr;
    public static int n,m;

    public static int solution(int first, int last) {
        int mid = (first + last) / 2;
        if(arr[mid] == m) return mid+1;
        else if(arr[mid] < m) return solution(mid+1, last);
        else return solution(first, mid-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        System.out.println(solution(0,arr.length-1));
    }
}
