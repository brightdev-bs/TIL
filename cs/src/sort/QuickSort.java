package sort;

public class QuickSort {

    static int[] data = {3, 10, 7, 5, 2, 15, 8, 12, 18, 25};

    public static void main(String[] args) {
        quickSort(data, 0, 9);

        for (int datum : data) {
            System.out.print(datum + " ");
        }
    }

    public static void quickSort(int[] data, int start, int end) {
        if(start >= end) {
            return;
        }

        int pivot = start;
        int i = pivot + 1;
        int j = end;
        int temp;
        while(i <= j) {
            while(i <= end && data[i] <= data[pivot]) {
                i++;
            }
            while(j > start && data[j] > data[pivot]) {
                j--;
            }

            if(i > j) {
                temp = data[j];
                data[j] = data[pivot];
                data[pivot] = temp;
            } else {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        quickSort(data, start, j - 1);
        quickSort(data, j + 1, end);
    }
}
