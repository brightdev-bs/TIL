package dummy.chapter7;

// perfect
public class Ch7_4_reminder {
    static int[] ch = new int[100001];

    public static int fibo(int n) {
        if(ch[n]!= 0) return ch[n];
        if(n == 1 || n == 2) return ch[n] = 1;
        else return ch[n] = fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        int n = 50;

        System.out.println(fibo(n));
    }
}
