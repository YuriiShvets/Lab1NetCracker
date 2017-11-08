package sorters.bubbleSort;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.Sort
 */
import sorters.Sort;

public abstract class BubbleSort extends Sort {

    /**
     *
     * @param arr input array of integers
     * @since 1.0
     */
    @Override
    public final void sort(int[] arr) {
        if(arr == null) {
            return;
        }
        for(int i = arr.length - 1; i != 0;) {  //i = index of last swap place
            int swapI = 0;
            for(int j = 0; j < i; j++) {
                int directedJ = checkDirect(arr.length, j);
                if(arr[directedJ] > arr[directedJ + 1]) {
                    swap(directedJ, directedJ + 1, arr);
                    swapI = j;
                }
            }
            i = swapI;
        }
    }

    /**
     *
     * @param arrSize size of array
     * @param j
     * @return directed j
     * @since 1.0
     */
    abstract int checkDirect(int arrSize, int j);
}
