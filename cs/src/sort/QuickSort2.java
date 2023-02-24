package sort;
public class QuickSort2 {

    static int[] data = {5, 3, 8, 9, 2, 4, 7};

    public static void main(String[] args) {
        quickSort(data, 0, data.length - 1);

        for (int datum : data) {
            System.out.print(datum + " ");
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    static int partition(int[] arr, int left,  int right) {
        int i = left, j = right;
        int pivot = arr[left];

        while(i < j) {
            while(arr[j] > pivot && i < j) {
                j--;
            }

            while(arr[i] <= pivot && i < j) {
                i++;
            }

            swap(arr, i, j);

        }

        swap(arr, left, i);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
