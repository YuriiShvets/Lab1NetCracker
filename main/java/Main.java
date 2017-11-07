import analyzer.Analyzer;
import analyzer.ReflectionWorker;

import java.lang.reflect.Method;

/**
 * Created by User on 01.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        ReflectionWorker reflectionWorker = new ReflectionWorker();
        Analyzer analyser = new Analyzer();

        System.out.println(reflectionWorker.getSortsNames());

        for(Method fill: reflectionWorker.getFillers()) {
            System.out.println(fill.toString());
            for(int i = 10; i < 100000; i += 1000) {
                System.out.println(i + " " + analyser.testSorts(i, fill, reflectionWorker.getSorts()));
            }
        }
    }
}
