package sorters.bubbleSort;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.bubbleSort.BubbleSort
 */
public class ReversedBubbleSort extends BubbleSort {

//    private static ReversedBubbleSort instance;
//
//    private ReversedBubbleSort() {
//        super();
//    }
//
//    /**
//     *
//     * @return instance of the class
//     */
//    public static ReversedBubbleSort newInstance() {
//        if(instance == null) {
//            instance = new ReversedBubbleSort();
//        }
//        return instance;
//    }

    /**
     *
     * @param arrSize size of array
     * @param j
     * @return directed j
     */
    @Override
    int checkDirect(int arrSize, int j) {
        j = arrSize - 2 - j;
        return j;
    }
}
