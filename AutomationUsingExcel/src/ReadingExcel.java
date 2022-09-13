import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingExcel {
    private final String filePath;
    private final List<OneCycleInputs> allInputs;

    public ReadingExcel(String filePath) {
        this.filePath = filePath;
        this.allInputs = new ArrayList<>();
    }

    public void read () throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(this.filePath));
        XSSFSheet sheet1 = workbook.getSheet("Sheet1");
        String[] results = new String[4];

        for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
            for (int column = 0; column < sheet1.getRow(1).getLastCellNum() - 1; column++) {
                results[column] = new DataFormatter().formatCellValue(sheet1.getRow(row).getCell(column));
            }
            OneCycleInputs oneCycleInputs = new OneCycleInputs(results[0], results[1], results[2], results[3]);
            allInputs.add(oneCycleInputs);
        }
    }

    public int numberOfRows() throws IOException {
        return new XSSFWorkbook(new FileInputStream(this.filePath)).getSheet("Sheet1").getLastRowNum();
    }
    public List<OneCycleInputs> getAllInputs() {
        return allInputs;
    }
}
