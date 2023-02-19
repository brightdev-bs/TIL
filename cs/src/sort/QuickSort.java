package src.sort.quicksort;

public class QuickSort {

    public static void main(String[] args) {
        int[] data = {5, 3, 8, 9, 2, 4, 7};
        quickSort(data, 0, 6);

        for (int datum : data) {
            System.out.print(datum + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    static int partition(int[] arr, int left, int right) {

        int pivot = arr[left];
        int lp = left;
        int rp = right;

        while(lp < rp) {

            while(arr[rp] > pivot && lp < rp) {
                rp--;
            }

            while(arr[lp] <= pivot && lp < rp) {
                lp++;
            }

            swap(arr, lp, rp);
        }

        swap(arr, left, lp);

        return lp;
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
