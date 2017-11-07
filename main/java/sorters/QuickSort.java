package sorters;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.Sort
 */

public class QuickSort extends Sort {

    /**
     *
     * @param arr array
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    /**
     *
     * @param start first index
     * @param end last index
     */
    private void quicksort(int[] arr, int start, int end) {
        int i = start, j = end;

        int middleElement = arr[start + (end - start) / 2];


        while (i <= j) {

            while (arr[i] < middleElement) {
                i++;
            }

            while (arr[j] > middleElement) {
                j--;
            }

            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
            }
        }

        if (start < j)
            quicksort(arr, start, j);
        if (i < end)
            quicksort(arr, i, end);
    }
}