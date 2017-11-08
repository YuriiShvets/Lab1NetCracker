package sorters;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.Sort
 */
import java.util.Arrays;

public class MergeSort extends Sort {

    /**
     *
     * @param arr input array of integers
     * @since 1.0
     */
    @Override
    public void sort(int[] arr) {

        if(arr == null) {
            return;
        }
        if (arr.length <= 1) {
            return;
        }
        int middl = arr.length / 2;  //middle element
        int[] arr1 = Arrays.copyOfRange(arr, 0, middl);
        int[] arr2 = Arrays.copyOfRange(arr, middl, arr.length);
        sort(arr1);
        sort(arr2);
        for (int i = 0, j = 0, k = 0; i < arr.length; i++) {
            if (j < middl)
                if (k < arr.length - middl)
                    if (arr1[j] <= arr2[k]) {
                        arr[i] = arr1[j];
                        j++;
                    } else {
                        arr[i] = arr2[k];
                        k++;
                    }
                else {
                    arr[i] = arr1[j];
                    j++;
                }
            else if (k < arr.length - middl) {
                arr[i] = arr2[k];
                k++;
            }
        }
    }
}

