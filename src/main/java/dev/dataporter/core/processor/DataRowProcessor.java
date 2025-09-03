package dev.dataporter.core.processor;

import dev.dataporter.core.model.data.DataColumn;
import dev.dataporter.core.model.data.DataRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class DataRowProcessor implements Processor<DataRow, Row>{
    @Override
    public DataRow process(DataRow dataRow, Row row) {
        for(Cell cell : row) {
            DataColumn dataColumn = new DataColumn();
            dataColumn.setColumnNo(cell.getColumnIndex());
            dataRow.getDataColumns().add(dataColumn);
        }
        return dataRow;
    }
}
