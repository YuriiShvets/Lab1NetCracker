package analyzer;

import fillers.Fillers;
import sorters.Sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * Created by User on 01.11.2017.
 * @authoe Shvets
 * @version 1.0
 */
public class Analyzer {

    private Fillers fillers = new Fillers();

    /**
     *
     * @param arrSize size of size
     * @param filler filler used to fill arrays
     * @param sorts List of sort objects
     * @return list of times of algoritms works
     */
    public LinkedList<Double> testSorts(int arrSize, Method filler, LinkedList<Sort> sorts) {

        LinkedList<Double> times = new LinkedList<>();

        int[] arr;
        for(Sort sort: sorts) {
            arr = fill(arrSize, filler);
            long time = System.nanoTime();
            sort.sort(arr);
            times.add((System.nanoTime() - time) / 1000000.);
        }

        return times;
    }

    /**
     *
     * @param size of array
     * @param filler filler used to fill
     * @return filled array
     */
    private int[] fill(int size, Method filler) {
        int[] arr = new int[size];
        try {
            arr = (int[])filler.invoke(fillers, arr.length);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
