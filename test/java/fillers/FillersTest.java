package fillers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 08.11.2017.
 */
public class FillersTest {
    private int arrSize = 100;

    @Test
    public void getSortedArr() throws Exception {
        int[] arr = Fillers.getSortedArr(arrSize);
        assertTrue(arrSize == arr.length);
        for(int i = 1; i < arr.length - 1; i++) {
            assertTrue(arr[i] >= arr[i - 1]);
        }

        try {
            arr = Fillers.getSortedArr(-1);
            assertTrue(false);
        } catch(IllegalArgumentException e) {
        }

        assertTrue(Fillers.getSortedArr(0) != null);
    }

    @Test
    public void getSortedArrWithRandomEnd() throws Exception {
        int[] arr = Fillers.getSortedArrWithRandomEnd(arrSize);
        assertTrue(arrSize == arr.length);
        for(int i = 1; i < arr.length - 2; i++) {
            assertTrue(arr[i] >= arr[i - 1]);
        }

        try {
            arr = Fillers.getSortedArrWithRandomEnd(-1);
            assertTrue(false);
        } catch(IllegalArgumentException e) {
        }

        assertTrue(Fillers.getSortedArrWithRandomEnd(0) != null);
    }

    @Test
    public void getReversedSortedArr() throws Exception {
        int[] arr = Fillers.getReversedSortedArr(arrSize);
        assertTrue(arrSize == arr.length);
        for(int i = 1; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i - 1]);
        }

        try {
            arr = Fillers.getReversedSortedArr(-1);
            assertTrue(false);
        } catch(IllegalArgumentException e) {
        }

        assertTrue(Fillers.getReversedSortedArr(0) != null);
    }

    @Test
    public void getRandomArr() throws Exception {
        int[] arr = Fillers.getRandomArr(arrSize);
        assertTrue(arrSize == arr.length);
        try {
            arr = Fillers.getRandomArr(-1);
            assertTrue(false);
        } catch(IllegalArgumentException e) {
        }

        assertTrue(Fillers.getRandomArr(0) != null);
    }

}