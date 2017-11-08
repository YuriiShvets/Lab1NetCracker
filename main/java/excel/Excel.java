package excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.charts.*;

/**
 * Created by User on 08.11.2017.
 */
public class Excel {

    public Excel(String fileName, LinkedList<Sheet> sheets) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        for(Sheet sheet: sheets) {
            XSSFSheet worksheet = workbook.createSheet(sheet.getName());

            XSSFRow row1 = worksheet.createRow(0);
            for (int colIndex = 0; colIndex < sheet.getColumnNames().size(); colIndex++) {
                XSSFCell cell = row1.createCell((short)colIndex + 1);
                cell.setCellValue(sheet.getColumnNames().get(colIndex));
            }

            for (int rowIndex = 0; rowIndex < sheet.getRows().size(); rowIndex++) {
                XSSFRow row = worksheet.createRow((short)rowIndex + 1);
                for (int colIndex = 0; colIndex < sheet.getRows().get(rowIndex).size(); colIndex++) {
                    XSSFCell cell = row.createCell((short)colIndex);
                    cell.setCellValue(sheet.getRows().get(rowIndex).get(colIndex));
                }
            }
            XSSFDrawing xlsx_drawing = worksheet.createDrawingPatriarch();

            //coordinats of graph
            XSSFClientAnchor anchor = xlsx_drawing.createAnchor(0, 0, 15, 15, 0, 1, 20, 50);
            XSSFChart lineChart = xlsx_drawing.createChart(anchor);
            XSSFChartLegend legend = lineChart.getOrCreateLegend();
            legend.setPosition(LegendPosition.BOTTOM);
            LineChartData data = lineChart.getChartDataFactory().createLineChartData();
            ChartAxis bottomAxis = lineChart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ValueAxis leftAxis = lineChart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            ChartDataSource<Number> xs = DataSources.fromNumericCellRange(worksheet, new CellRangeAddress(1, sheet.getRows().size() + 1, 0, 0));

            for (int colIndex = 1; colIndex < sheet.getRows().get(0).size(); colIndex++) {
                ChartDataSource<Number> ys = DataSources.fromNumericCellRange(worksheet, new CellRangeAddress(1, sheet.getRows().size() + 1, colIndex, colIndex));
                data.addSeries(xs, ys);
            }

            lineChart.plot(data, new ChartAxis[] { bottomAxis, leftAxis });
        }
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
    }
}
