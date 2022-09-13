import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    private String filePath;

    public WriteExcel(String filePath) {
        this.filePath = filePath;
    }

    public void write(int row, String value) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(this.filePath));
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        sheet.getRow(row).getCell(sheet.getRow(row).getLastCellNum()-1).setCellValue(value);

        FileOutputStream file = new FileOutputStream(this.filePath);
        workbook.write(file);
        file.close();
    }
}
