package sort;

public class MergeSort2 {

    static int[] sorted = new int[10];

    public static void main(String[] args) {
        int[] list = {3, 10, 7, 5, 2, 15, 8, 12, 18, 25};

        mergeSort(list, 0, 9);
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, l;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                sorted[k++] = arr[i++];
            }

            if(arr[i] > arr[j]) {
                sorted[k++] = arr[j++];
            }
        }

        if(i <= mid) {
            for(l = i; l <= mid; l++) {
                sorted[k++] = arr[l];
            }
        } else {
            for(l = j; l <= right; l++) {
                sorted[k++] = arr[l];
            }
        }

        for(l = left; l <= right; l++) {
            arr[l] = sorted[l];
        }
    }
}
