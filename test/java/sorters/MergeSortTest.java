package sorters;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 31.10.2017.
 */
public class MergeSortTest {

    @Test
    public void sort() throws Exception {
        Sort sort = new MergeSort();

        int[] arr = {1, 15, 8, 3, 9};
        sort.sort(arr);

        int[] checkArr = {1, 3, 8, 9, 15};
        assertTrue(Arrays.equals(arr, checkArr));


        arr = null;
        sort.sort(arr);
        assertTrue(arr == null);
    }

}