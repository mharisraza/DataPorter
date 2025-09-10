package dev.dataporter;

import com.github.pjfanning.xlsx.StreamingReader;
import dev.dataporter.constant.TestConstant;
import dev.dataporter.core.config.loader.ConfigLoader;
import dev.dataporter.core.config.model.Config;
import dev.dataporter.core.config.model.ConfigGlobalRule;
import dev.dataporter.core.config.parser.ConfigParser;
import dev.dataporter.core.model.data.DataSet;
import dev.dataporter.core.model.data.DataSheet;
import dev.dataporter.core.model.validation.ValidationResult;
import dev.dataporter.core.processor.DataRowProcessor;
import dev.dataporter.core.processor.DataSetProcessor;
import dev.dataporter.core.processor.DataSheetProcessor;
import dev.dataporter.core.processor.Processor;
import dev.dataporter.core.processor.engine.ProcessingEngine;
import dev.dataporter.core.validator.DataSheetValidator;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Path;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataPorterApplicationTests {

	private Config config;
	private Workbook workbook;
	private DataSet dataSet;
	private ValidationResult validationResult;

	@Test
	@Order(1)
	void loadAndParseConfiguration() throws IOException {
		String loadedRawConfiguration = new ConfigLoader(Path.of(new ClassPathResource(TestConstant.PATH_TO_CONFIG).getFile().getAbsolutePath())).load();
		Config loadedConfiguration = new ConfigParser(loadedRawConfiguration).parse();
		this.config = loadedConfiguration;
		assert loadedConfiguration != null && !loadedConfiguration.getHeaderConfigs().isEmpty();
	}

	@Test
	@Order(2)
	void loadFileAsWorkbook() throws IOException {
		InputStream is = new FileInputStream(new ClassPathResource(TestConstant.PATH_TO_EXCEL_FILE).getFile());
		this.workbook = StreamingReader.builder()
				.rowCacheSize(500)
				.bufferSize(4096)
				.open(is);
		assert workbook != null;
	}

	@Test
	@Order(3)
	void testProcessor() throws IOException {

		DataSet dataSet = new DataSet();
		ValidationResult validationResult = new ValidationResult();
		DataSheetValidator dataSheetValidator = new DataSheetValidator(config.getConfigGlobalRule(), validationResult);

		ProcessingEngine processingEngine = new ProcessingEngine()
				.withDataSetProcessor(new DataSetProcessor())
				.withDataSheetProcessor(new DataSheetProcessor(dataSheetValidator))
				.withDataRowProcessor(new DataRowProcessor());

		processingEngine.startProcess(dataSet, workbook);
		this.dataSet = dataSet;
		this.validationResult = validationResult;
		assert !dataSet.getDataSheets().isEmpty();
	}

	@Test
	@Order(4)
	void testValidation() {
		dataSet.getDataSheets().forEach(sheet -> {
			checkGlobalValidationApplied(sheet, validationResult);
		});
	}

	private void checkGlobalValidationApplied(DataSheet dataSheet, ValidationResult validationResult) {
		ConfigGlobalRule configGlobalRule = config.getConfigGlobalRule();

		if(dataSheet.getDataRows().size() - 1 <= configGlobalRule.getMinRowsCount()) {
			assert validationResult.shouldProcessHalted();
		}
		assert true;
	}

}
