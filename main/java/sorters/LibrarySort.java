package sorters;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.Sort
 */
import java.util.*;

public class LibrarySort extends Sort {
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
        Arrays.sort(arr);
    }
}
