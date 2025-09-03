package dev.dataporter.core.model.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DataSet {
    private String fileName;
    private List<DataSheet> dataSheets = new ArrayList<DataSheet>();
}
