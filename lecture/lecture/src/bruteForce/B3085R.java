package bruteForce;

import java.util.Scanner;

public class B3085R {

    static int check(char[][] a) {
        int length = a.length;
        int ans = 1;
        for(int i = 0; i < length; i++) {
            int cnt = 1;
            for(int j = 1; j < length; j++) {
                if(a[i][j] == a[i][j-1]) cnt++;
                else cnt = 1;
                ans = Math.max(ans, cnt);
            }

            cnt = 1;
            for(int j = 1; j < length; j++) {
                if(a[j][i] == a[j-1][i]) cnt++;
                else cnt = 1;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        char[][] arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        int ans = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j+1 < n) {
                    char tmp = arr[i][j]; arr[i][j] = arr[i][j+1]; arr[i][j+1] = tmp;
                    int check = check(arr);
                    ans = Math.max(ans, check);
                    tmp = arr[i][j]; arr[i][j] = arr[i][j+1]; arr[i][j+1] = tmp;
                }
                if(i+1 < n) {
                    char tmp = arr[i][j]; arr[i][j] = arr[i+1][j]; arr[i+1][j] = tmp;
                    int check = check(arr);
                    ans = Math.max(ans, check);
                    tmp = arr[i][j]; arr[i][j] = arr[i+1][j]; arr[i+1][j] = tmp;
                }
            }
        }

        System.out.println(ans);
    }
}
