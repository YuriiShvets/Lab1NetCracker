package sorters;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 01.11.2017.
 */
public class LibrarySortTest {
    @Test
    public void sort() throws Exception {
        Sort sort = new LibrarySort();

        int[] arr = {1, 15, 8, 3, 9};
        sort.sort(arr);

        int[] checkArr = {1, 3, 8, 9, 15};
        assert(Arrays.equals(arr, checkArr));
    }

}