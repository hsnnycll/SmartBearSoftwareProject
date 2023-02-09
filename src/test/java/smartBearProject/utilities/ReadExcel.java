package smartBearProject.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ReadExcel {

    int rowIndexOfTestCase;
    int columnIndexOfTestCase;
    DataFormatter dataFormatter = new DataFormatter();

    public HashMap<String, String> getDataFromExcel(String testCaseName, String workbookName, String sheetName) throws IOException {
        HashMap<String, String> excelData = new HashMap<>();

        FileInputStream fis = new FileInputStream("src/test/resources/testData/" + workbookName + ".xlsx");
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        for (int rowIndex = 0; rowIndex < sheet.getLastRowNum(); rowIndex++) {
            boolean isTestCaseFound = false;
            Row currentRow = sheet.getRow(rowIndex);
            if (currentRow != null) {
                for (int columnIndex = 0; columnIndex < currentRow.getLastCellNum(); columnIndex++) {
                    if (currentRow.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
                        String formattedCellValueAsString = dataFormatter.formatCellValue(currentRow.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));
                        if (formattedCellValueAsString.equalsIgnoreCase("TestCase")) {
                            rowIndexOfTestCase = rowIndex;
                            columnIndexOfTestCase = columnIndex;
                            isTestCaseFound = true;
                            break;
                        }
                    }
                }
            }
            if (isTestCaseFound) {
                break;
            }
        }

        for (int rowIndex = rowIndexOfTestCase; rowIndex < sheet.getLastRowNum(); rowIndex++) {
            Row currentRow = sheet.getRow(rowIndex);
            Row headerRow = sheet.getRow(rowIndexOfTestCase);
            Cell testCaseCell = currentRow.getCell(columnIndexOfTestCase, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (testCaseCell != null){
                if (testCaseCell.getStringCellValue().equalsIgnoreCase(testCaseName)){
                    for (int columnIndex = columnIndexOfTestCase; columnIndex < headerRow.getLastCellNum(); columnIndex++) {
                        Cell currentCell = currentRow.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                        Cell headerCell = headerRow.getCell(columnIndex);
                        if (currentCell != null && headerCell != null){
                            try {
                                String key = dataFormatter.formatCellValue(headerCell);
                                String value = dataFormatter.formatCellValue(currentCell);
                                excelData.put(key, value);
                            }catch (IllegalArgumentException exception) {
                                exception.printStackTrace();
                                Assert.fail(exception.getMessage());
                            }
                        }
                    }
                    break;
                }
            }
        }
        return excelData;
    }
}
