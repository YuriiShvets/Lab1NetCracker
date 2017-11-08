package excel;

import java.util.LinkedList;

/**
 * Created by User on 08.11.2017.
 */
public class Sheet {

    private String name;
    private LinkedList<String> columnNames;
    private LinkedList<LinkedList<Double>> rows;

    public Sheet(String name, LinkedList<String> columnNames, LinkedList<LinkedList<Double>> rows) {
        this.name = name;
        this.columnNames = columnNames;
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getColumnNames() {
        return columnNames;
    }

    public LinkedList<LinkedList<Double>> getRows() {
        return rows;
    }
}
