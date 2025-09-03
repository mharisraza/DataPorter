package dev.dataporter.core.processor;

import dev.dataporter.core.model.data.DataRow;
import dev.dataporter.core.model.data.DataSet;
import dev.dataporter.core.model.data.DataSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class DataSheetProcessor implements Processor<DataSheet, Sheet>{

    @Override
    public DataSheet process(DataSheet dataSheet, Sheet sheet) {
        for(Row row : sheet) {
            DataRow dataRow = new DataRow();
            dataRow.setRowNumber(row.getRowNum());
            dataSheet.getDataRows().add(dataRow);
        }
        return dataSheet;
    }
}
