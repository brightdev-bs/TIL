package com.mango;

import java.util.*;

class Main {
    public int count(int[] arr, int distance) {
        int ep = arr[0];
        int cnt = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= distance) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = -1;
        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(T.count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

