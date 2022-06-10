package algorithm.baekjoon;

import java.io.*;
import java.util.*;

// ArrayList로 매번 정렬을 하게 되면 시간 초과가 발생할 수 밖에 없음. 시간 제한: 0.1
public class B1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size())
                maxHeap.add(input);
            else
                minHeap.add(input);
            if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
            bw.write(maxHeap.peek() + "\n");
        }
        bw.flush();
    }
}
