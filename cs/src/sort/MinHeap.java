package sort;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> heap = new ArrayList<>();

    public MinHeap() {
        heap.add(0);
    }

    public void insert(int v) {
        heap.add(v);
        int p = heap.size() - 1;
        while (p > 1 && heap.get(p / 2) > heap.get(p)) {
            int tmp = heap.get(p/2);
            heap.set(p/2, p);
            heap.set(p, tmp);

            p /= 2;
        }
    }

    public int delete() {
        if(heap.size() - 1 < 1) {
            return 0;
        }

        int deleteElement = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;

        while((pos * 2) < heap.size()) {
            int min = heap.get(pos*2);
            int minPos = pos * 2;

            if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
                min = heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            if(min > heap.get(pos)) break;

            // 부모 자식 교환
            int tmp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, tmp);
            pos = minPos;
        }

        return deleteElement;
    }
}
