package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B12865 {

    // 그리디로 풀면 안되는 이유?
    // -> 그리디는 탐욕적으로 가장 작거나, 가장 큰 수를 뽑는 알고리즘.
    // -> 내가 짠 로직에서는 무게를 기준으로 정렬되어 있으므로 작은 weight를 계속 뽑아냄
    // -> 근데 작은 1번 -> 2번 -> 3번 이렇게 뽑아낼텐데
    // -> 1번 -> 3번이 더 최적의 해일수도 있음.
    // -> 냅색 알고리즘을 이용한다.
//    private void wrongLogic() {
//        int answer = 0;
//        for(int i = 0; i < n-1; i++) {
//            int sum = 0, weight = 0;
//            weight += items[i].weight;
//            sum += items[i].value;
//            for(int j = i + 1; j < n; j++) {
//                if(weight + items[j].weight <= k) {
//                    weight += items[j].weight;
//                    sum += items[j].value;
//                }
//            }
//            answer = Math.max(answer, sum);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 물품의 수
        int k = sc.nextInt(); // 준서가 버티는 무게
        int[] bag = new int[k+1];

        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for(int j = k; j >= w; j--) {
                bag[j] = Math.max(bag[j], v + bag[j-w]);
            }
        }

        System.out.println(bag[k]);
    }
}
