package excel;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by User on 08.11.2017.
 */
public class SheetTest {
    private String name = "TEST";
    private LinkedList<String> columns = new LinkedList<>();
    private LinkedList<LinkedList<Double>> data = new LinkedList<>();
    Sheet sheet;

    @Before
    public void setUp() throws Exception {
        columns.add("1");
        columns.add("2");
        columns.add("3");
        data.add(new LinkedList<>());
        data.add(new LinkedList<>());
        data.add(new LinkedList<>());

        data.get(1).add(4d);
        data.get(1).add(5d);
        data.get(1).add(6d);

        data.get(2).add(7d);
        data.get(2).add(8d);
        data.get(2).add(9d);

        data.get(3).add(10d);
        data.get(3).add(11d);
        data.get(3).add(12d);

        sheet = new Sheet(name, columns, data);
    }

    @Test
    public void getName() throws Exception {
        assertTrue(sheet.equals(name));
    }

    @Test
    public void getColumnNames() throws Exception {
        
    }

    @Test
    public void getRows() throws Exception {

    }

}