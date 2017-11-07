package sorters;

/**
 * @author Shvets
 * @version 1.0
 * @see java.util.Arrays#sort(int[])
 *
 */

public abstract class Sort {

    /**
     * @param arr input array of integers
     * @since 1.0
     */
    public abstract void sort(int[] arr);

    /**
     *
     * @param i index of first element
     * @param j index of second element
     * @param arr array
     * @since 1.0
     */
    protected void swap(int i, int j, int[] arr) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }
}
