import analyzer.Analyzer;
import analyzer.ReflectionWorker;
import excel.Excel;
import excel.Sheet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * Created by User on 01.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ReflectionWorker reflectionWorker = new ReflectionWorker();
        Analyzer analyser = new Analyzer();

        LinkedList<Sheet> sheets = new LinkedList<>();
        for(Method fill: reflectionWorker.getFillers()) {
            LinkedList<LinkedList<Double>> rows = new LinkedList<>();
            for(int i = 1000; i < 100000; i += 1000) {
                rows.add(analyser.testSorts(i, fill, reflectionWorker.getSorts()));
            }
            sheets.add(new Sheet(fill.getName().split("get")[1], reflectionWorker.getSortsNames(), rows));
        }

        try {
            Excel excel = new Excel("sortsResults.xlsx", sheets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(reflectionWorker.getSortsNames());
//
//        for(Method fill: reflectionWorker.getFillers()) {
//            System.out.println(fill.getName().split("get")[1]);
//            for(int i = 1000; i < 100000; i += 1000) {
//                System.out.println(analyser.testSorts(i, fill, reflectionWorker.getSorts()));
//            }
//        }
    }
}
