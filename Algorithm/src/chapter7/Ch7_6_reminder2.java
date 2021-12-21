package chapter7;

public class Ch7_6_reminder2 {
    static int[] ch = new int[4];

    public static void solution(int n, int length) {
        if(length == n + 1) {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1)
                    System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[length] = 1;
            solution(n, length +1);
            ch[length] = 0;
            solution(n, length+1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        solution(n, 1);
    }
}
