package fillers;

/**
 * @author Shvets
 * @version 1.0
 */
import java.util.Random;


public class Fillers {

    private static int bound = 100;
    private static Random random = new Random();

    /**
     *
     * @param size size of the required array
     * @return sorted array or null if size == 0
     * @throws IllegalArgumentException when size < 0
     * @since 1.0
     */
    @Filler
    public static int[] getSortedArr(int size) throws IllegalArgumentException {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        arr[0] = random.nextInt(bound);
        for(int i = 1; i < size; i++) {
            arr[i] = arr[i - 1] + random.nextInt(bound);
        }
        return arr;
    }

    /**
     *
     * @param size size of the required array
     * @return sorted array with random number in the end or null if size == 0
     * @throws IllegalArgumentException when size < 0
     * @since 1.0
     */
    @Filler
    public static int[] getSortedArrWithRandomEnd(int size) throws IllegalArgumentException {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        int[] arr = getSortedArr(size);
        arr[size - 1] = random.nextInt(bound);
        return arr;
    }

    /**
     *
     * @param size size of the required array
     * @return reversed sorted array or null if size == 0
     * @throws IllegalArgumentException when size < 0
     * @since 1.0
     */
    @Filler
    public static int[] getReversedSortedArr(int size) throws IllegalArgumentException {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        int[] arr = getSortedArr(size);
        for(int i = 0; i < size / 2; i++) {
            int buf = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = buf;
        }
        return arr;
    }

    /**
     *
     * @param size size of the required array
     * @return random array or null if size == 0
     * @throws IllegalArgumentException when size < 0
     * @since 1.0
     */
    @Filler
    public  static int[] getRandomArr(int size) throws IllegalArgumentException {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
