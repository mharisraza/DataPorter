package dev.dataporter.core.processor.engine;

import dev.dataporter.core.model.data.DataRow;
import dev.dataporter.core.model.data.DataSet;
import dev.dataporter.core.processor.DataRowProcessor;
import dev.dataporter.core.processor.DataSetProcessor;
import dev.dataporter.core.processor.DataSheetProcessor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public class ProcessingEngine {
    private DataSetProcessor dataSetProcessor;
    private DataSheetProcessor dataSheetProcessor;
    private DataRowProcessor dataRowProcessor;

    public ProcessingEngine withDataSetProcessor(final DataSetProcessor dataSetProcessor) {
        this.dataSetProcessor = dataSetProcessor;
        return this;
    }

    public ProcessingEngine withDataSheetProcessor(final DataSheetProcessor dataSheetProcessor) {
        this.dataSheetProcessor = dataSheetProcessor;
        return this;
    }

    public ProcessingEngine withDataRowProcessor(final DataRowProcessor dataRowProcessor) {
        this.dataRowProcessor = dataRowProcessor;
        return this;
    }

    public void startProcess(DataSet dataSet, Workbook workbook) throws IOException {
        try (workbook) {
            dataSetProcessor.process(dataSet, workbook);
            dataSet.getDataSheets().forEach(dataSheet -> {
                Sheet sheet = workbook.getSheetAt(dataSheet.getSheetNo());
                dataSheetProcessor.process(dataSheet, sheet);
                for (Row row : sheet) {
                    DataRow dataRow = dataSheet.getDataRows().get(row.getRowNum());
                    dataRowProcessor.process(dataRow, row);
                }
            });
        }
    }

}
