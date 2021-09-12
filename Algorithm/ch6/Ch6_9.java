package com.mango;

import java.util.*;

class ch6_9 {
    public int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for(int x : arr) {
            if(capacity < sum + x) {
                cnt++;
                sum = x;
            } else
                sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        count(arr, m);

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            }
            else {
                lt = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ch6_9 T = new ch6_9();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = T.solution(n, m , arr);
        System.out.println(answer);

    }
}

