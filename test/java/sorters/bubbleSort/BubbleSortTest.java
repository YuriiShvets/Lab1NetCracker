package sorters.bubbleSort;

import org.junit.Test;
import sorters.MergeSort;
import sorters.Sort;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 01.11.2017.
 */
public class BubbleSortTest {
    @Test
    public void sort() throws Exception {
        Sort sort = new DirectBubbleSort();

        int[] arr = {1, 15, 8, 3, 9};
        sort.sort(arr);

        int[] checkArr = {1, 3, 8, 9, 15};
        assertTrue(Arrays.equals(arr, checkArr));


        arr = null;
        sort.sort(arr);
        assertTrue(arr == null);


        sort = new ReversedBubbleSort();

        arr = new int[]{1, 15, 8, 3, 9};
        sort.sort(arr);

        assertTrue(Arrays.equals(arr, checkArr));


        arr = null;
        sort.sort(arr);
        assertTrue(arr == null);
    }

}