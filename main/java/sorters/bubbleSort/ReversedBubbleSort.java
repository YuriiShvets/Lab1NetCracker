package sorters.bubbleSort;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.bubbleSort.BubbleSort
 */
public class ReversedBubbleSort extends BubbleSort {

    /**
     *
     * @param arrSize size of array
     * @param j
     * @return directed j
     * @since 1.0
     */
    @Override
    int checkDirect(int arrSize, int j) {
        j = arrSize - 2 - j;
        return j;
    }
}
