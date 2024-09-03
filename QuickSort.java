public class QuickSort {
    public static void main(String[] args) {
        int[] unsortedArray = {10, 8, 19, 11, 50, 78, 34, 90};
        System.out.println("Unsorted Array:");
        printArray(unsortedArray);
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("Sorted Array (Ascending):");
        printArray(unsortedArray);
        quickSort(unsortedArray, 0, unsortedArray.length - 1, false);
        System.out.println("Sorted Array (Descending):");
        printArray(unsortedArray);
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    public static void quickSort(int[] array, int low, int high, boolean descending) {
        if (low < high) {
            int partitionIndex = partition(array, low, high, descending);
            quickSort(array, low, partitionIndex - 1, descending);
            quickSort(array, partitionIndex + 1, high, descending);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private static int partition(int[] array, int low, int high, boolean descending) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if ((descending && array[j] >= pivot) || (!descending && array[j] <= pivot)) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


