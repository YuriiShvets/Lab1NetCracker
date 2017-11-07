package sorters;

/**
 * @author Shvets
 * @version 1.0
 * @see sorters.Sort
 */
public class ShellSort extends Sort {

//    private static ShellSort instance;
//
//    private ShellSort() {
//        super();
//    }
//
//    /**
//     * @return instance of the class
//     */
//    public static ShellSort newInstance() {
//        if(instance == null) {
//            instance = new ShellSort();
//        }
//        return instance;
//    }
    /**
     * @param arr input array of integers
     */
    @Override
    public void sort(int []arr) {
        if(arr == null) {
            return;
        }
        for (int d = arr.length/2; d >= 1; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                for (int j = i; j >= d && arr[j - d] > arr[j]; j -= d) {
                    swap(j, j - d, arr);
                }
            }
        }
    }
}
