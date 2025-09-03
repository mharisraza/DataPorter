package dev.dataporter.core.model.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataSheet  {
    private int sheetNo;
    private String sheetName;
    private List<DataRow> dataRows = new ArrayList<DataRow>();

}
