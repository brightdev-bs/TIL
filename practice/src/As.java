import java.util.Scanner;

public class As {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p0 = 3, p1 = 0, p2 = 2, pi,pj, pk, pa;

        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);

        int p3 = p0 + p1;
        int p4 = p2 + p1;

        System.out.println(p3);
        System.out.println(p4);

        pj = p3; pi = p2; pk = p4;

        for(int i = 5; i <= n; i++) {
            pa = pj + pi;
            System.out.println(pa);
            pi = pj; pj = pk; pk = pa;
        }
    }
}
