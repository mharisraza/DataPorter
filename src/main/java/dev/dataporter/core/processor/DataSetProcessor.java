package dev.dataporter.core.processor;

import dev.dataporter.core.model.data.DataSet;
import dev.dataporter.core.model.data.DataSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataSetProcessor implements Processor<DataSet, Workbook> {
    @Override
    public DataSet process(DataSet dataSet, Workbook workbook) {
        int sheetCount = 0;
        for(Sheet sheet : workbook) {
            DataSheet dataSheet = new DataSheet();
            dataSheet.setSheetNo(sheetCount);
            dataSheet.setSheetName(sheet.getSheetName());
            dataSet.getDataSheets().add(dataSheet);
            sheetCount++;
        }
        return dataSet;
    }
}
