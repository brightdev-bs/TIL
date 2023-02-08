package sort;

public class MergeSort {

    static int[] sorted = new int[10];

    public static void main(String[] args) {
        int[] list = {3, 10, 7, 5, 2, 15, 8, 12, 18, 25};

        mergeSort(list, 0, 9);
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] list, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list,mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    public static void merge(int[] list, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, l;

        while(i <= mid && j <= right) {
            if (list[i] <= list[j]) {
                sorted[k++] = list[i++];
            } else {
                sorted[k++] = list[j++];
            }
        }

        // 남아 있는 값 일괄 복사
        if(i > mid) {
            for(l = j; l <= right; l++){
                sorted[k++] = list[l];
            }
        } else {
            for(l = i; l <= mid; l++) {
                sorted[k++] = list[l];
            }
        }

        for(l = left; l <= right; l++) {
            list[l] = sorted[l];
        }
    }

}