package excel;

import java.util.LinkedList;

/**
 * Created by User on 08.11.2017.
 * @author Shvets
 * @version 1.0
 */
public class Sheet {

    private String name;
    private LinkedList<String> columnNames;
    private LinkedList<LinkedList<Double>> rows;

    /**
     *
     * @param name name of sheet
     * @param columnNames list of names of columns
     * @param rows data
     */
    public Sheet(String name, LinkedList<String> columnNames, LinkedList<LinkedList<Double>> rows) {
        this.name = name;
        this.columnNames = columnNames;
        this.rows = rows;
    }

    /**
     *
     * @return name of Sheet
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return names of columns
     * @since 1.0
     */
    public LinkedList<String> getColumnNames() {
        return columnNames;
    }

    /**
     *
     * @return data
     * @since 1.0
     */
    public LinkedList<LinkedList<Double>> getRows() {
        return rows;
    }
}
