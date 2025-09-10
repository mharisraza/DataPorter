package dev.dataporter.core.processor;

import dev.dataporter.core.model.data.DataRow;
import dev.dataporter.core.model.data.DataSet;
import dev.dataporter.core.model.data.DataSheet;
import dev.dataporter.core.validator.DataSheetValidator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class DataSheetProcessor implements Processor<DataSheet, Sheet> {

    private final DataSheetValidator dataSheetValidator;

    public DataSheetProcessor(DataSheetValidator dataSheetValidator) {
        this.dataSheetValidator = dataSheetValidator;
    }

    @Override
    public DataSheet process(DataSheet dataSheet, Sheet sheet) {
        for(Row row : sheet) {
            DataRow dataRow = new DataRow();
            dataRow.setRowNumber(row.getRowNum());
            dataRow.setPhysicallyEmpty(isRowPhysicallyEmpty(row));
            dataSheet.getDataRows().add(dataRow);
        }
        dataSheetValidator.validate(dataSheet);
        return dataSheet;
    }

    /*
     * rows/cells which had content and set to empty later are still counted.
     *
     * so if row is physically empty then we'll mark it as empty row.
     */
    private boolean isRowPhysicallyEmpty(Row row) {
      return row.getPhysicalNumberOfCells() == 0;
    }
}
