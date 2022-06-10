package dummy.chapter7;

public class Ch7_6_reminder {
    static int[] ch = new int[1000];

    public static void DFS(int n, int end) {
        if(n == end + 1) {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[n] = 1;
            DFS(n+1, end);
            ch[n] = 0;
            DFS(n+1, end);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        DFS(1, n);
    }
}
