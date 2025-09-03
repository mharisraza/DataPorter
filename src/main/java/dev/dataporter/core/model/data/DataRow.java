package dev.dataporter.core.model.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataRow {
    private int rowNumber;
    private List<DataColumn> dataColumns = new ArrayList<DataColumn>();

    public DataRow(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
