package analyzer;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by User on 01.11.2017.
 */
public class AnalyzerTest {
    @Test
    public void testSorts() throws Exception {
        Analyzer analyzer = new Analyzer();
        ReflectionWorker reflectionWorker = new ReflectionWorker();
        analyzer.testSorts(15, reflectionWorker.getFillers().get(0), reflectionWorker.getSorts());
    }
}