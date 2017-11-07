package sorters;

import fillers.Fillers;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 31.10.2017.
 */
public class QuickSortTest {
//    @Test
//    public void getInstance() throws Exception {
//        QuickSort sort = QuickSort.newInstance();
//        QuickSort sort2 = QuickSort.newInstance();
//        assertEquals(sort, sort2);
//    }

    @Test
    public void sort() throws Exception {
        Sort sort = new QuickSort();

        int[] arr = {1, 15, 8, 3, 9};
        sort.sort(arr);

        int[] checkArr = {1, 3, 8, 9, 15};
        assert(Arrays.equals(arr, checkArr));
    }

}