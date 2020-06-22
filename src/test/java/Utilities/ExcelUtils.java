package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String SheetName) throws IOException {

        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(SheetName);
    }

    public static void getCellData(int rowNum, int colNum) {

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);


    }

    public static void getRowCount() throws Exception {

        //String excelPath = "TestData"+ File.separator +"Data.xlsx";
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);

    }
}
